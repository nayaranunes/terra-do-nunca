package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Championship;

import java.util.List;

public interface ChampionshipRepository {
    int insertChampionship(Championship championship);

    List<Championship> selectAllChampionships();

    Championship selectChampionshipByName(String name);

    Championship selectChampionshipById(Long id);

    int deleteChampionshipById(Long id);

    int updateChampionshipById(Long id, Championship championship);


}
