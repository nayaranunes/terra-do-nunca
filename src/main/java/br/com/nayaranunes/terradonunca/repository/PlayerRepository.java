package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.model.PlayerRequest;

import java.util.List;

public interface PlayerRepository {

    int insertPlayer(Player player);

    List<Player> selectAllPlayers();

    Player selectPlayerByCPF(String cpf);

    boolean playerAlreadyExists(String cpf);

    int deletePlayerByCPF(String cpf);

    int updatePlayerByCPF(String cpf, PlayerRequest request);

    boolean playersExists(List<String> cpf);

    List<Player> selectPlayersByCPFList(List<String> cpf);

    //PlayerResponse selectPlayerById(Long id);
    //int updatePlayerById(long id, PlayerRequest request);
}

