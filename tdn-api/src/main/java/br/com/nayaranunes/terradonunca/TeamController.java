package br.com.nayaranunes.terradonunca;

import br.com.nayaranunes.terradonunca.entitys.Team;
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
    private void addTeam(@RequestBody TeamRequest request){
        teamService.addTeam(request);
    }

    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamResponse getTeamById(@PathVariable("id") Integer id) {
        return teamService.findById(id);
    }

    @GetMapping("teste/{id}")
    public List<Team> aTeamById(@PathVariable("id") Integer id) {
        return teamService.findAllTeams(id);
    }
/*

    @PutMapping("/{id}")
    public void updateTeamById(@PathVariable("id") Integer id, @RequestBody TeamRequest request) {
        teamService.updateById(id, request);
    }
*/

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        teamService.deleteById(id);
    }

//    @GetMapping("/players/{cnpj}")
//    public List<Player> getAllPlayersOfTeam(@PathVariable("cnpj") String cnpj){
//        return teamService.getAllPlayersByCnpj(cnpj);
//    }
}