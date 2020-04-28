package br.com.nayaranunes.terradonunca.service;

import br.com.nayaranunes.terradonunca.domain.*;
import br.com.nayaranunes.terradonunca.exception.ApiRequestException;
import br.com.nayaranunes.terradonunca.repository.ChampionshipRepository;
import br.com.nayaranunes.terradonunca.repository.TeamDataAcessService;
import br.com.nayaranunes.terradonunca.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ChampionshipService {

    private final ChampionshipRepository championshipRepository;

    TeamDataAcessService teamDataAcessService = new TeamDataAcessService();
    TeamService teamService = new TeamService(teamDataAcessService);

    //List<NextPhase> DBNextPhase = new ArrayList<>();
    NextPhase nextPhase = new NextPhase();

    @Autowired
    public ChampionshipService(@Qualifier("championshipRepository") ChampionshipRepository championshipRepository) {
        this.championshipRepository = championshipRepository;
    }

    public Long addChampionship(Championship championship) {
        Random random = new Random();
        Long id = Math.abs(random.nextLong());
        championship.setId(id);
        if (!(teamService.teamsExists(championship.getTeams()))) {
            throw new ApiRequestException("Some team of the list doesn't exists");
        }
        if (!(championship.getTeams().size() >= 4)) {
            throw new ApiRequestException("The minimum numbers of teams are four");
        }
        if (!(championship.getTeams().size() <= 16)) {
            throw new ApiRequestException("The maximum numbers of teams are sixteen");
        }
        if (championshipRepository.selectChampionshipByName(championship.getName()) != null) {
            throw new ApiRequestException("The championship already exists");
        }
        int qtdOfTeams = championship.getTeams().size();
        championship.setPhase(setPhase(qtdOfTeams));
        championshipRepository.insertChampionship(championship);
        return championship.getId();
    }

    public List<Championship> getAllChampionships() {
        if (championshipRepository.selectAllChampionships() == null) {
            throw new ApiRequestException("None championship exists");
        }
        return championshipRepository.selectAllChampionships();
    }

    public Championship getChampionshipById(Long id) {
        if (championshipRepository.selectChampionshipById(id) == null) {
            throw new ApiRequestException("This championship doesn't exists");
        }
        return championshipRepository.selectChampionshipById(id);
    }

    public int deleteChampionshipById(Long id) {
        if (championshipRepository.deleteChampionshipById(id) == 0) {
            throw new ApiRequestException("This championship doesn't exists");
        }
        return championshipRepository.deleteChampionshipById(id);
    }

    public int updateChampionshipById(Long id, Championship championship) {
        if (championshipRepository.updateChampionshipById(id, championship) == 0) {
            throw new ApiRequestException("This championship doesn't exists");
        }
        return championshipRepository.updateChampionshipById(id, championship);
    }

    public String setPhase(int qtdOfTeams) {
        //PHASE
        //1- final 2 teams
        //2- semifinal 4 teams
        //3- quartas 8 teams
        //4- oitavas ate 16 teams

        if (qtdOfTeams == 4) {
            return "Next phase = final";
        }
        if (qtdOfTeams <= 8) {
            return "Next phase = semifinal";
        }
        return "Next phase = quartas";
    }

    public Round makeTableById(Long id) {
        // MATAMATA
        Championship championship = getChampionshipById(id);
        int qtdOfTeams = championship.getTeams().size();
        List<Team> listOfTeams = teamService.getTeamsByNameList(championship.getTeams());
        //qtdOfTeams < 8
        if (qtdOfTeams < 8) {
            return mataMata(listOfTeams, qtdOfTeams);
        }
        //qtdOfTeams = 8 or 16
        if (qtdOfTeams == 8 || qtdOfTeams == 16) {
            return new Round (null, mataMataPar(listOfTeams));
        }
        // 16 > qtdOfTeams > 8
        return mataMata(listOfTeams, qtdOfTeams);
    }

    public Round mataMata(List<Team> listOfTeams, int qtdOfTeams) {
        int index = 0;
        if (qtdOfTeams < 8 && qtdOfTeams >= 4) {
            index = ((qtdOfTeams - 4) * 2);
        }
        if (qtdOfTeams > 8 && qtdOfTeams < 16) {
            index = ((qtdOfTeams - 8) * 2);
        }
        int qtdNextPhase = qtdOfTeams - index;
        List<Team> teams = new ArrayList<>();
        while (qtdNextPhase != 0) {
            teams.add(listOfTeams.get(0));
            listOfTeams.remove(0);
            qtdNextPhase--;
        }
        nextPhase.setTeams(teams);
        return new Round(nextPhase, mataMataPar(listOfTeams));
    }

    public List<SoccerMatch> mataMataPar(List<Team> listOfTeams) {
        List<SoccerMatch> soccerMatches = new ArrayList<>();
        Random rand1 = new Random();
        Random rand2 = new Random();
        while (!listOfTeams.isEmpty()) {
            fulling(listOfTeams, soccerMatches, rand1, rand2);
        }
        return soccerMatches;
    }

    public void fulling(List<Team> listOfTeams, List<SoccerMatch> soccerMatches, Random rand1, Random rand2) {
        SoccerMatch soccerMatch = new SoccerMatch();
        int randomIndex1 = rand1.nextInt(listOfTeams.size());
        soccerMatch.setTeamOne(listOfTeams.get(randomIndex1));
        listOfTeams.remove(randomIndex1);
        int randomIndex2 = rand2.nextInt(listOfTeams.size());
        soccerMatch.setTeamTwo(listOfTeams.get(randomIndex2));
        listOfTeams.remove(randomIndex2);
        soccerMatches.add(soccerMatch);
    }

    //TO DO
    public List<SoccerMatch> makeTableNextPhase(Long id, NextPhase listWinners) {
        Championship championship = getChampionshipById(id);
        int qtdOfTeams = nextPhase.getTeams().size() + listWinners.getWinnersNames().size();
        List<Team> listOfTeams = nextPhase.getTeams();
        List<Team> trash = teamService.getTeamsByNameList(championship.getTeams()); //all teams of championship
        for (Team team : trash) {
            if (team.getName().equals(listWinners.getWinnersNames())) {     //select all winner team
                listOfTeams.add(team);
            }
        }
        //qtdOfTeams < 8
        if (qtdOfTeams < 8) {
            return (List<SoccerMatch>) mataMata(listOfTeams, qtdOfTeams);
        }
        //qtdOfTeams = 8 or 16
        if (qtdOfTeams == 8 || qtdOfTeams == 16) {
            return (mataMataPar(listOfTeams));
        }
        // 16 > qtdOfTeams > 8
        return (List<SoccerMatch>) mataMata(listOfTeams, qtdOfTeams);
    }

}
