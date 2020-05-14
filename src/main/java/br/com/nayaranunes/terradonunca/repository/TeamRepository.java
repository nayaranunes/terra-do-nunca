package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Team;
import br.com.nayaranunes.terradonunca.model.TeamRequest;

import java.util.List;

public interface TeamRepository {

    int insertTeam(Team team);

    List<Team> selectAllTeams();

    Team selectTeamByCNPJ(String cnpj);

    int deleteTeamByCNPJ(String cnpj);

    int updateTeamByCNPJ(String cnpj, TeamRequest request);

    boolean teamsExists(List<String> teams);

    Team selectTeamByName(String name);

    List<Team> selectTeamsByNameList(List<String> teams);

    boolean teamAlreadyExists(String cnpj);

}

