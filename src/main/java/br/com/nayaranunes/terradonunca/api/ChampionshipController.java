package br.com.nayaranunes.terradonunca.api;

import br.com.nayaranunes.terradonunca.domain.*;
import br.com.nayaranunes.terradonunca.service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Integer addChampionship(@RequestBody Championship championship) {
        return championshipService.addChampionship(championship);
    }

    @GetMapping
    public List<Championship> getAllChampionships() {
        return championshipService.findAll();
    }

    @GetMapping("/{id}")
    public Championship getChampionshipById(@PathVariable("id") Integer id) {
        return championshipService.findById(id);
    }

    @DeleteMapping("/{id}")
    public int deleteChampionshipById(@PathVariable("id") Integer id) {
        return championshipService.deleteById(id);
    }

    @PutMapping("/{id}")
    public int updateChampionshipById(@PathVariable("id") Integer id,
                                      @RequestBody Championship championship) {
        return championshipService.updateById(id, championship);
    }

    @GetMapping("/{id}/teams")
    public List<Team> allTeams(@PathVariable("id") Integer id) {
        return championshipService.allTeams(id);
    }

/*
    @GetMapping("/{id}/oitavas")
    public List<Math> oitavas(@PathVariable("id") Integer id) {
        return championshipService.oitavas(id);
    }

    @PostMapping("/{id}/oitavas")
    public void oitavas(@PathVariable("id") Integer id, @RequestBody List<Integer> ids) {
        championshipService.setChampions(id, ids);
    }
*/

    @GetMapping("/{id}/quartas")
    public List<List<Team>> quartas(@PathVariable("id") Integer id) {
        return championshipService.quartas(id);
    }

    @PostMapping("/{id}/quartas")
    public void oitavas(@PathVariable("id") Integer id, @RequestBody Champions ids) {
        championshipService.setChampions(id, ids);
    }

    @GetMapping("/{id}/semi")
    public List<List<Team>> semi(@PathVariable("id") Integer id) {
        return championshipService.semi(id);
    }

    @PostMapping("/{id}/semi")
    public void semi(@PathVariable("id") Integer id, @RequestBody Champions ids) {
        championshipService.setChampions(id, ids);
    }

    @GetMapping("/{id}/final")
    public List<Team> theFinal(@PathVariable("id") Integer id) {
        return championshipService.theFinal(id);
    }

    @PostMapping("/{id}/final")
    public void theFinal(@PathVariable("id") Integer id, @RequestBody Champions ids) {
        championshipService.setChampions(id, ids);
    }

    @GetMapping("/{id}/champion")
    public Team champion(@PathVariable("id") Integer id) {
        return championshipService.champion(id);
    }

}
