package br.com.nayaranunes.terradonunca.service;

import br.com.nayaranunes.terradonunca.domain.Champions;
import br.com.nayaranunes.terradonunca.domain.*;
import br.com.nayaranunes.terradonunca.exception.ApiRequestException;
import br.com.nayaranunes.terradonunca.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ChampionshipService {

    private final ChampionshipRepository championshipRepository;
    private final TeamService teamService;

    @Autowired
    public ChampionshipService(ChampionshipRepository championshipRepository, TeamService teamService) {
        this.championshipRepository = championshipRepository;
        this.teamService = teamService;
    }

    public Integer addChampionship(Championship championship) {
        if (!championshipRepository.findByName(championship.getName())) {
            throw new ApiRequestException("The championship already exists");
        }
        championshipRepository.save(championship);
        return championship.getId();
    }

    public List<Championship> findAll() {
        if (championshipRepository.findAll() == null) {
            throw new ApiRequestException("None championship exists");
        }
        return championshipRepository.findAll();
    }

    public Championship findById(Integer id) {
        if (championshipRepository.findById(id).get() == null) {
            throw new ApiRequestException("This championship doesn't exists");
        }
        return championshipRepository.findById(id).get();
    }

    public int deleteById(Integer id) {
        if (championshipRepository.findById(id) == null) {
            throw new ApiRequestException("This championship doesn't exists");
        }
        championshipRepository.deleteById(id);
        return 1;
    }

    public int updateById(Integer id, Championship championship) {
        if (championshipRepository.findById(id).get() == null) {
            throw new ApiRequestException("This championship doesn't exists");
        }
        var up = championshipRepository.findById(id).get();
        up.setYear(championship.getYear());
        up.setName(championship.getName());
        championshipRepository.save(up);
        return 1;
    }

    public List<Team> allTeams(Integer id) {
        if (teamService.findAllTeams(id) == null) {
            throw new ApiRequestException("None team registered");
        }
        return teamService.findAllTeams(id);
    }

    public void setChampions(Integer id, Champions ids) {
        var c = championshipRepository.findById(id).get();
        c.setPhase();
        championshipRepository.save(c);
        List<Integer> championsID = new ArrayList<>();
        ids.getChampions().forEach(i -> championsID.add(i));
        teamService.setChampionsTeams(championsID);
    }

    public List<List<Team>> quartas(Integer id) {
        List<Team> listOfTeams = teamService.findAllTeams(id);
        return mataMataPar(listOfTeams);
    }

    public List<List<Team>> semi(Integer id) {
        var championship = championshipRepository.findById(id).get();
        List<Team> listOfTeams = teamService.findAllChampions(championship.getPhase());
        return mataMataPar(listOfTeams);
    }

    public List<Team> theFinal(Integer id) {
        var championship = championshipRepository.findById(id).get();
        return teamService.findAllChampions(championship.getPhase());
    }

    public Team champion(Integer id) {
        var championship = championshipRepository.findById(id).get();
        return teamService.findChampion(championship.getPhase());

    }

    public List<List<Team>> mataMataPar(List<Team> listOfTeams) {
        List<List<Team>> matchs = new ArrayList<>();
        Random rand1 = new Random();
        Random rand2 = new Random();
        while (!listOfTeams.isEmpty()) {
            matchs.add(fulling(listOfTeams, rand1, rand2));
        }
        return matchs;
    }

    public List<Team> fulling(List<Team> listOfTeams, Random rand1, Random rand2) {
        int randomIndex1 = rand1.nextInt(listOfTeams.size());
        List<Team> match = new ArrayList<>();
        match.add(listOfTeams.get(randomIndex1));
        listOfTeams.remove(randomIndex1);
        int randomIndex2 = rand2.nextInt(listOfTeams.size());
        match.add(listOfTeams.get(randomIndex2));
        listOfTeams.remove(randomIndex2);
        return match;
    }
/*
        if (qtdOfTeams < 8 && qtdOfTeams >= 4) {
            index = ((qtdOfTeams - 4) * 2);
        }
        if (qtdOfTeams > 8 && qtdOfTeams < 16) {
            index = ((qtdOfTeams - 8) * 2);
        }
*/
}
