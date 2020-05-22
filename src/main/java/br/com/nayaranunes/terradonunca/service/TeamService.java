package br.com.nayaranunes.terradonunca.service;

import br.com.nayaranunes.terradonunca.domain.Team;
import br.com.nayaranunes.terradonunca.exception.ApiRequestException;
import br.com.nayaranunes.terradonunca.model.TeamRequest;
import br.com.nayaranunes.terradonunca.model.TeamResponse;
import br.com.nayaranunes.terradonunca.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public int addTeam(TeamRequest request) {
       if (teamRepository.findByCnpj(request.getCnpj()) != null) {
           throw new ApiRequestException("This team already exists");
       }
       teamRepository.save(new Team(request.getCoach(), request.getCnpj(),
               request.getName(), request.getChampionshipId()));
       return 1;
    }

    public List<Team> findAll() {
        if (teamRepository.findAll() == null) {
            throw new ApiRequestException("None team exists");
        }
        return teamRepository.findAll();
    }

    public TeamResponse findById(Integer id) {
        if (teamRepository.findById(id).get() == null) {
            throw new ApiRequestException("This team doesn't exists");
        }
        Team team = teamRepository.findById(id).get();
        return new TeamResponse(team.getCoach(), team.getCnpj(),
                team.getName());
    }

    public int deleteById(Integer id) {
        if (teamRepository.findById(id).get() == null) {
            throw new ApiRequestException("This team doesn't exists");
        }
        teamRepository.deleteById(id);
        return 1;
    }

    public int updateById(Integer id, TeamRequest request) {
        var up = teamRepository.findById(id).get();
        up.setCoach(request.getCoach());
        up.setName(request.getName());
        up.setCnpj(request.getCnpj());
        teamRepository.save(up);
        return 1;
    }

    public List<Team> findAllTeams(Integer id) {
        return teamRepository.findAllByChampionshipId(id);
    }

    public void setChampionsTeams(List<Integer> ids) {
        while (!ids.isEmpty()) {
            Team team = teamRepository.findById(ids.get(0)).get();
            team.setStatus();
            teamRepository.save(team);
            ids.remove(0);
        }
    }

    public List<Team> findAllChampions(Integer phase) {
        return teamRepository.findAllChampions(phase);
    }

    public Team findChampion(Integer phase) {
        return teamRepository.findChampion(phase);
    }
}
