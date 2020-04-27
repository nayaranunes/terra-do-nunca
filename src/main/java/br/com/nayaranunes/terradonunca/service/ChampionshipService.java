package br.com.nayaranunes.terradonunca.service;

import br.com.nayaranunes.terradonunca.domain.Championship;
import br.com.nayaranunes.terradonunca.domain.SoccerMatch;
import br.com.nayaranunes.terradonunca.domain.Team;
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
        if (!(championship.getTeams().size() >= 6)) {
            throw new ApiRequestException("The minimum numbers of teams are six");
        }
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

    public List<SoccerMatch> makeTableById(Long id) {
        // MATAMATA
        Championship championship = getChampionshipById(id);
        System.out.println(championship.getId());
        if (championship.getTeams().size() % 2 == 0) {
            return mataMataPar(teamService.getTeamsByNameList(championship.getTeams()));
        } else {
            return mataMataImpar(teamService.getTeamsByNameList(championship.getTeams()));
        }
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

    public List<SoccerMatch> mataMataImpar(List<Team> listOfTeams) {
        List<SoccerMatch> soccerMatches = new ArrayList<>();
        Random rand1 = new Random();
        Random rand2 = new Random();
        while (listOfTeams.size() != 1) {
            fulling(listOfTeams, soccerMatches, rand1, rand2);
        }
        SoccerMatch soccerMatch = new SoccerMatch(listOfTeams.get(0),null);
        soccerMatches.add(soccerMatch);
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
}
