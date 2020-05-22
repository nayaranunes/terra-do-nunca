package br.com.nayaranunes.terradonunca.service;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.exception.ApiRequestException;
import br.com.nayaranunes.terradonunca.model.PlayerRequest;
import br.com.nayaranunes.terradonunca.model.PlayerResponse;
import br.com.nayaranunes.terradonunca.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService (PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public int addPlayer(PlayerRequest request) {
        if (playerRepository.findByCpf(request.getCpf()) != null) {
            throw new ApiRequestException("The player already exists");
        }
        playerRepository.save(new Player(request.getName(),
                request.getCpf(), request.getTeam_id()));
        return 1;
    }

    public PlayerResponse findByCpf(String cpf) {
        var player = playerRepository.findByCpf(cpf);
        if (player == null) {
            throw new ApiRequestException("The player doesn't exists");
        }
        return new PlayerResponse(player.getName(), player.getCpf(), player.getTeamId());
    }

    public List<PlayerResponse> findAll() {
        if (playerRepository.findAll() == null) {
            throw new ApiRequestException("None player exists");
        }
        var it = playerRepository.findAll();
        var allPlayers = new ArrayList<PlayerResponse>();
        it.forEach(e -> allPlayers.add(new PlayerResponse(e.getName(), e.getCpf(), e.getTeamId())));
        return allPlayers;
    }

    public int deleteById(Integer id) {
        if (playerRepository.findById(id).get() == null) {
            throw new ApiRequestException("This player doesn't exists");
        }
        playerRepository.deleteById(id);
        return 1;
    }

    public int updateById(Integer id, PlayerRequest request) {
        if (playerRepository.findById(id).get() == null) {
            throw new ApiRequestException("This player doesn't exists");
        }
        Player player = playerRepository.findById(id).get();
        player.setCpf(request.getCpf());
        player.setName(request.getName());
        player.setTeamId(request.getTeam_id());
        playerRepository.save(player);
        return 1;
    }

}
