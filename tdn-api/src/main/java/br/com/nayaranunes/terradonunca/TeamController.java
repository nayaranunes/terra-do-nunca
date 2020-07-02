package br.com.nayaranunes.terradonunca;

import br.com.nayaranunes.terradonunca.entitys.Team;
import br.com.nayaranunes.terradonunca.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Team>> getAllTeams(){
        return new ResponseEntity<>(teamService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(teamService.findById(id), HttpStatus.OK);
    }

    @GetMapping("teste/{id}")
    public ResponseEntity<List<Team>> aTeamById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(teamService.findAllTeams(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        teamService.deleteById(id);
    }

}