package br.com.nayaranunes.terradonunca.service;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.domain.Team;
import br.com.nayaranunes.terradonunca.exception.ApiRequestException;
import br.com.nayaranunes.terradonunca.model.TeamRequest;
import br.com.nayaranunes.terradonunca.model.TeamResponse;
import br.com.nayaranunes.terradonunca.repository.PlayerDataAcessService;
import br.com.nayaranunes.terradonunca.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    PlayerDataAcessService playerRepository = new PlayerDataAcessService();

    @Autowired
    public TeamService(@Qualifier("teamRepository") TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    PlayerDataAcessService playerDataAcessService = new PlayerDataAcessService();
    PlayerService playerService = new PlayerService(playerDataAcessService);

    public int addTeam(TeamRequest request) {
       Random random = new Random();
       Long id = Math.abs(random.nextLong());
       if (teamAlreadyExists(request.getCNPJ())) {
           throw new ApiRequestException("This team already exists");
       }
       if (!(playerService.playersExists(request.getListOfPlayersCPF()))) {
           throw new ApiRequestException("Any player of the list doesn't exists");
       }
       if (playerAlreadyHasTeam(request.getListOfPlayersCPF())) {
           throw new ApiRequestException("Any player of the list already has team");
       }
       playersHasTime(request.getListOfPlayersCPF());
       Team team = new Team(id, request.getCoach(), request.getCNPJ(),
                   request.getName(), request.getListOfPlayersCPF());
       return teamRepository.insertTeam(team);
    }

    public boolean teamAlreadyExists(String cnpj) {
        return teamRepository.teamAlreadyExists(cnpj);
    }

    public void playersHasTime(List<String> cpf) {
        List<Player> players = playerService.getPlayersByCPFList(cpf);
        for (Player player : players){
            player.setHasTime(true);
        }
    }

    public boolean playerAlreadyHasTeam(List<String> cpf) {
        int i = 0;
        List<Player> players = playerService.getPlayersByCPFList(cpf);
        for (Player player : players) {
            if (player.isHasTime()) {
                i++;
            }
        }
        return i != 0;
    }

    public List<Team> getAllTeams() {
        if (teamRepository.selectAllTeams() == null) {
            throw new ApiRequestException("None team exists");
        }
        return teamRepository.selectAllTeams();
    }

    public TeamResponse getTeamByCNPJ(String cnpj) {
        if (teamRepository.selectTeamByCNPJ(cnpj) == null) {
            throw new ApiRequestException("This team doesn't exists");
        }
        Team team = teamRepository.selectTeamByCNPJ(cnpj);
        return new TeamResponse(team.getCoach(), team.getCNPJ(),
                team.getName(), team.getListOfPlayers());
    }

    public int deleteTeamByCNPJ(String cnpj) {
        if (teamRepository.deleteTeamByCNPJ(cnpj) == 0) {
            throw new ApiRequestException("This team doesn't exists");
        }
        return teamRepository.deleteTeamByCNPJ(cnpj);
    }

    public int updateTeamByCNPJ(String cnpj, TeamRequest request) {
        if (teamRepository.updateTeamByCNPJ(cnpj, request) == 0) {
            throw new ApiRequestException("This team doesn't exists");
        }
        return teamRepository.updateTeamByCNPJ(cnpj, request);
    }

    public List<Player> getAllPlayersByCnpj(String cnpj) {
        if (teamRepository.selectTeamByCNPJ(cnpj) == null) {
            throw new ApiRequestException("None players exists");
        }
        Team team = teamRepository.selectTeamByCNPJ(cnpj);
        team.setListOfPlayers(playerService.getPlayersByCPFList(team.getListOfPlayersCPF()));
        return team.getListOfPlayers();
    }

    public boolean teamsExists(List<String> teams) {
        return teamRepository.teamsExists(teams);
    }

    public List<Team> getTeamsByNameList(List<String> teams) {
        return teamRepository.selectTeamsByNameList(teams);
    }
}
