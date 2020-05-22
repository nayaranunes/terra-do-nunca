package br.com.nayaranunes.terradonunca.api;

import br.com.nayaranunes.terradonunca.model.PlayerRequest;
import br.com.nayaranunes.terradonunca.model.PlayerResponse;
import br.com.nayaranunes.terradonunca.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    private void addPlayer(@RequestBody PlayerRequest request) {
        playerService.addPlayer(request);
    }

    @GetMapping
    public List<PlayerResponse> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{cpf}")
    public PlayerResponse getPlayerById(@PathVariable("cpf") String cpf) {
        return playerService.findByCpf(cpf);

    }

    @DeleteMapping("/{id}")
    public void deletePlayerByCPF(@PathVariable("id") Integer id) {
        playerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updatePlayerById(@PathVariable("id") Integer id,
                                 @RequestBody PlayerRequest request) {
        playerService.updateById(id, request);
    }
}

