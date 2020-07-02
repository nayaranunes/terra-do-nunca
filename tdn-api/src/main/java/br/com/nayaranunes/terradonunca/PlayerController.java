package br.com.nayaranunes.terradonunca;

import br.com.nayaranunes.terradonunca.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable("cpf") String cpf) {
        return new ResponseEntity<>(playerService.findByCpf(cpf), HttpStatus.OK);

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
