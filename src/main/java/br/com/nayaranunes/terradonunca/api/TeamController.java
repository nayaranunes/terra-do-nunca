package br.com.nayaranunes.terradonunca.api;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.domain.Team;
import br.com.nayaranunes.terradonunca.model.TeamRequest;
import br.com.nayaranunes.terradonunca.model.TeamResponse;
import br.com.nayaranunes.terradonunca.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    private void addTeam(@RequestBody TeamRequest request){ //gets the json and saves the team
        teamService.addTeam(request);
    }
    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }
    @PutMapping("/{cnpj}")
    public void updateTeamByCNPJ(@PathVariable("cnpj") String cnpj, @RequestBody TeamRequest request) {
        teamService.updateTeamByCNPJ(cnpj, request);
    }
    @DeleteMapping("/{cnpj}")
    public void deleteTeamByCNPJ(@PathVariable("cnpj") String cnpj) {
        teamService.deleteTeamByCNPJ(cnpj);
    }
    @GetMapping("/{cnpj}")
    public TeamResponse getTeamByCNPJ(@PathVariable("cnpj") String cnpj) {
        return teamService.getTeamByCNPJ(cnpj);
    }
    @GetMapping("/players/{cnpj}")
    public List<Player> getAllPlayersOfTeam(@PathVariable("cnpj") String cnpj){
        return teamService.getAllPlayersByCnpj(cnpj);
    }
}
