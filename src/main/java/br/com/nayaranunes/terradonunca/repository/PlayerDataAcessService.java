/*
package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Player;
import br.com.nayaranunes.terradonunca.model.PlayerRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("playerRepository")
public class PlayerDataAcessService implements PlayerRepository {
    public static List<Player> DBP = new ArrayList<>();
    public static List<String> CPFP = new ArrayList<>();

    @Override
    public int insertPlayer(Player player) {
        DBP.add(player);
        CPFP.add(player.getCPF());
        return 1;
    }

    @Override
    public List<Player> selectAllPlayers() {
        if (DBP.isEmpty()) {
            return null;
        }
        return DBP;
    }

    @Override
    public Player selectPlayerByCPF(String cpf) {
        for (Player p : DBP) {
            if (p.getCPF().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public int deletePlayerByCPF(String cpf) {
        var player = selectPlayerByCPF(cpf);
        if (player == null) {
            return 0;
        }
        DBP.remove(player);
        CPFP.remove(player.getCPF());
        return 1;
    }

    @Override
    public int updatePlayerByCPF(String cpf, PlayerRequest request) {
        var exists = selectPlayerByCPF(cpf);
        if (exists == null) {
            return 0;
        }
        //ID still same
        exists.setName(request.getName());
        exists.setCPF(request.getCPF());
        return 1;
    }

    @Override
    public boolean playersExists(List<String> cpf) {
        int i = 0;
        for (String c : cpf) {      //checking every single cpf
            for (Player p : DBP) {      //passing by every single player
                if (p.getCPF().equals(c)) {
                    i++;
                }
            }
        }
        return i == cpf.size();
    }

    @Override
    public List<Player> selectPlayersByCPFList(List<String> cpf) {
        List<Player> listOfPlayers = new ArrayList<>();
        for (String c : cpf) {
            listOfPlayers.add(selectPlayerByCPF(c));
        }
        return listOfPlayers;
    }

    @Override
    public boolean playerAlreadyExists(String cpf) {
        return (CPFP.contains(cpf));
    }
}
*/
