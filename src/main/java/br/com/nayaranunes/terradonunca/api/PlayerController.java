package br.com.nayaranunes.terradonunca.api;

import br.com.nayaranunes.terradonunca.domain.Player;
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
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{cpf}")
    public void updatePlayerByCPF(@PathVariable("cpf") String cpf, @RequestBody PlayerRequest request) {
        playerService.updatePlayerByCPF(cpf, request);
    }

    @DeleteMapping("/{cpf}")
    public void deletePlayerByCPF(@PathVariable("cpf") String cpf) {
        playerService.deletePlayerByCPF(cpf);
    }

    @GetMapping("/{cpf}")
    public PlayerResponse getPlayerByCPF(@PathVariable("cpf") String cpf) {
        return playerService.getPlayerByCPF(cpf);
    }
}

