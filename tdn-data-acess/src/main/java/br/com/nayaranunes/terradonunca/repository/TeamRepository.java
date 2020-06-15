package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.entitys.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "SELECT t FROM Team t WHERE t.cnpj= ?1")
    Team findByCnpj(String cnpj);

    @Query(value = "SELECT t FROM Team t WHERE t.championshipId= ?1")
    List<Team> findAllByChampionshipId(Integer id);

    @Query(value = "SELECT t FROM Team t WHERE t.status= ?1")
    List<Team> findAllChampions(Integer phase);

    @Query(value = "SELECT t FROM Team t WHERE t.status= ?1")
    Team findChampion(Integer phase);
}

