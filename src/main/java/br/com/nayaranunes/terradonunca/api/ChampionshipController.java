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
    private Long addPlayer(@RequestBody Championship championship) {
        return championshipService.addChampionship(championship);
    }

    @GetMapping
    public List<Championship> getAllChampionships() {
        return championshipService.getAllChampionships();
    }

    @PutMapping("/{idOfChampionship}")
    public int updateChampionshipById(@PathVariable("idOfChampionship") Long id,
                                      @RequestBody Championship championship) {
        return championshipService.updateChampionshipById(id, championship);
    }

    @DeleteMapping("/{idOfChampionship}")
    public int deleteChampionshipById(@PathVariable("idOfChampionship") Long id) {
        return championshipService.deleteChampionshipById(id);
    }

    @GetMapping("/{idOfChampionship}")
    public Championship getChampionshipById(@PathVariable("idOfChampionship") Long id) {
        return championshipService.getChampionshipById(id);
    }

    @GetMapping("/table/{idOfChampionship}")
    public Round tableById(@PathVariable("idOfChampionship") Long id) {
        return championshipService.makeTableById(id);
    }

}
