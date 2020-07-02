package br.com.nayaranunes.terradonunca;

import br.com.nayaranunes.terradonunca.entitys.Champions;
import br.com.nayaranunes.terradonunca.entitys.Championship;
import br.com.nayaranunes.terradonunca.entitys.Team;
import br.com.nayaranunes.terradonunca.service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/championships")
public class ChampionshipController {

    private final ChampionshipService championshipService;

    @Autowired
    public ChampionshipController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    @PostMapping
    private ResponseEntity<Integer> addChampionship(@RequestBody Championship championship) {
        return new ResponseEntity<>(championshipService.addChampionship(championship), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Championship>> getAllChampionships() {
        return new ResponseEntity<>(championshipService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Championship> getChampionshipById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(championshipService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteChampionshipById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(championshipService.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateChampionshipById(@PathVariable("id") Integer id,
                                      @RequestBody Championship championship) {
        return new ResponseEntity<>(championshipService.updateById(id, championship), HttpStatus.OK);
    }

    @GetMapping("/{id}/teams")
    public ResponseEntity<List<Team>> allTeams(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(championshipService.allTeams(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/quartas")
    public ResponseEntity<List<List<Team>>> quartas(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(championshipService.quartas(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/quartas")
    public void oitavas(@PathVariable("id") Integer id, @RequestBody Champions ids) {
        championshipService.setChampions(id, ids);
    }

    @GetMapping("/{id}/semi")
    public ResponseEntity<List<List<Team>>> semi(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(championshipService.semi(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/semi")
    public void semi(@PathVariable("id") Integer id, @RequestBody Champions ids) {
        championshipService.setChampions(id, ids);
    }

    @GetMapping("/{id}/final")
    public ResponseEntity<List<Team>> theFinal(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(championshipService.theFinal(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/final")
    public void theFinal(@PathVariable("id") Integer id, @RequestBody Champions ids) {
        championshipService.setChampions(id, ids);
    }

    @GetMapping("/{id}/champion")
    public ResponseEntity<Team> champion(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(championshipService.champion(id), HttpStatus.OK);
    }

}
