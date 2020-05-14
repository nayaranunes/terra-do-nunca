package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Team;
import br.com.nayaranunes.terradonunca.model.TeamRequest;
import br.com.nayaranunes.terradonunca.service.PlayerService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("teamRepository")
public class TeamDataAcessService implements TeamRepository {

    public static List<Team> DBT = new ArrayList<>();
    public static List<String> CNPJT = new ArrayList<>();

    //PlayerDataAcessService playerDataAcessService = new PlayerDataAcessService();
    //PlayerService playerService = new PlayerService(playerDataAcessService);
    @Override
    public int insertTeam(Team team) {
   //     team.setListOfPlayers(playerService.getPlayersByCPFList(team.getListOfPlayersCPF()));
        DBT.add(team);
        CNPJT.add(team.getCNPJ());
        return 1;
    }

    @Override
    public List<Team> selectAllTeams() {
        if (DBT.isEmpty()) {
            return null;
        }
        return DBT;
    }

    @Override
    public Team selectTeamByCNPJ(String cnpj) {
        for(Team t : DBT) {
            if(t.getCNPJ().equals(cnpj)){
                return t;
            }
        }
        return null;
    }

    @Override
    public int deleteTeamByCNPJ(String cnpj) {
        var team = selectTeamByCNPJ(cnpj);
        if (team == null){
            return 0;
        }
        DBT.remove(team);
        return 1;
    }

    @Override
    public int updateTeamByCNPJ(String cnpj, TeamRequest request) {
        var exists = selectTeamByCNPJ(cnpj);
        if (exists == null) {
            return 0;
        }
        //ID still same
        exists.setCoach(request.getCoach());
        exists.setCNPJ(request.getCNPJ());
        exists.setName(request.getName());
        return 1;
    }

    @Override
    public boolean teamsExists(List<String> teams) {
        int i = 0;
        for (String team : teams) {
            for (Team t : DBT) {
                if (t.getName().equals(team)) {
                    i++;
                }
            }
        }
        return i == teams.size();
    }

    @Override
    public Team selectTeamByName(String name){
        for(Team n : DBT) {
            if(n.getName().equals(name)){
                return n;
            }
        }
        return null;
    }

    @Override
    public List<Team> selectTeamsByNameList(List<String> teams) {
        List<Team> listOfTeams = new ArrayList<>();
        for (String team : teams) {
            listOfTeams.add(selectTeamByName(team));
        }
        return listOfTeams;
    }

    @Override
    public boolean teamAlreadyExists(String cnpj) {
        return CNPJT.contains(cnpj);
    }

}
