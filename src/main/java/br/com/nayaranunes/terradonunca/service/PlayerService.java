package br.com.nayaranunes.terradonunca.service;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.exception.ApiRequestException;
import br.com.nayaranunes.terradonunca.model.PlayerRequest;
import br.com.nayaranunes.terradonunca.model.PlayerResponse;
import br.com.nayaranunes.terradonunca.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository; //interface
    //@Qualifier -> allow a lot of types of data base
    //Various implementations for the same interface

    @Autowired
    public PlayerService(@Qualifier("playerRepository") PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public int addPlayer(PlayerRequest request) {
        Random random = new Random();
        Long id = Math.abs(random.nextLong());
        if (playerAlreadyExists(request.getCPF())) {
            throw new ApiRequestException("The player already exists");
        }
        Player player = new Player(id, request.getName(), request.getCPF());
        return playerRepository.insertPlayer(player);
    }

    public boolean playerAlreadyExists(String cpf) {
        return playerRepository.playerAlreadyExists(cpf);
    }

    public PlayerResponse getPlayerByCPF(String cpf) {
        if (playerRepository.selectPlayerByCPF(cpf) == null) {
            throw new ApiRequestException("The player doesn't exists");
        }
        Player player = playerRepository.selectPlayerByCPF(cpf);
        return new PlayerResponse(player.getName(), player.getCPF());
    }

    public List<PlayerResponse> getAllPlayers() {
        if (playerRepository.selectAllPlayers() == null) {
            throw new ApiRequestException("None player exists");
        }
        List<Player> players = playerRepository.selectAllPlayers();
        List<PlayerResponse> responses = new ArrayList<>();
        for (Player p : players) {
            PlayerResponse response = new PlayerResponse(p.getName(), p.getCPF());
            responses.add(response);
        }
        return responses;
    }

    public int deletePlayerByCPF(String cpf) {
        if (playerRepository.deletePlayerByCPF(cpf) == 0) {
            throw new ApiRequestException("This player doesn't exists");
        }
        return playerRepository.deletePlayerByCPF(cpf);
    }

    public int updatePlayerByCPF(String cpf, PlayerRequest request) {
        if (playerRepository.updatePlayerByCPF(cpf, request) == 0) {
            throw new ApiRequestException("This player doesn't exists");
        }
        return playerRepository.updatePlayerByCPF(cpf, request);
    }

    public boolean playersExists(List<String> cpf) {
        return playerRepository.playersExists(cpf);
    }

    public List<Player> getPlayersByCPFList(List<String> cpf) {
        return playerRepository.selectPlayersByCPFList(cpf);
    }
}
