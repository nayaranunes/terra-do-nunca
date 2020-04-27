package br.com.nayaranunes.terradonunca.repository;

import br.com.nayaranunes.terradonunca.domain.Championship;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("championshipRepository")
public class ChampionshipDataAcessService implements ChampionshipRepository {
    public static List<Championship> DBC = new ArrayList<>();

    @Override
    public int insertChampionship(Championship championship) {
        DBC.add(championship);
        championship.setQtdOfTeams(championship.getTeams().size());
        return 1;
    }

    @Override
    public List<Championship> selectAllChampionships() {
        return DBC;
    }

    @Override
    public Championship selectChampionshipByName(String name) {
        for (Championship dbc : DBC) {
            if (dbc.getName().equals(name)) {
                return dbc;
            }
        }
        return null;
    }

    @Override
    public Championship selectChampionshipById(Long id) {
        for (Championship dbc : DBC) {
            if (dbc.getId().equals(id)) {
                return dbc;
            }
        }
        return null;
    }

    @Override
    public int deleteChampionshipById(Long id) {
        for (Championship dbc : DBC) {
            if (dbc.getId().equals(id)) {
                DBC.remove(dbc);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateChampionshipById(Long id, Championship championship) {
        var c = selectChampionshipById(id);
        if (c == null) {
            return 0;
        }
        //ID still same
        c.setName(championship.getName());
        c.setYear(championship.getYear());
        c.setTeams(c.getTeams());
        return 1;
    }
}
