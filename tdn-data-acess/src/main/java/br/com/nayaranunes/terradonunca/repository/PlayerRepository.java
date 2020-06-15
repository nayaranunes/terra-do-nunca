package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.entitys.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "SELECT p FROM Player p WHERE p.cpf= ?1")
    Player findByCpf(String cpf);


}

