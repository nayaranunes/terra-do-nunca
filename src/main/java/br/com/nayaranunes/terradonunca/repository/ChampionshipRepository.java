package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Championship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
    boolean findByName(String name);
}
