package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.entitys.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {

    @Query(value = "SELECT c FROM Championship c WHERE c.name= ?1")
    boolean findByName(String name);
}
