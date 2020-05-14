package br.com.nayaranunes.terradonunca.persistence;

import br.com.nayaranunes.terradonunca.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepositoryPersistense extends JpaRepository<Player, Long> {
}
