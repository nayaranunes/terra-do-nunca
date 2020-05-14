package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}

