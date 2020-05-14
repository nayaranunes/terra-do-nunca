package br.com.nayaranunes.terradonunca.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

//@Entity
//@Table(name = "championship")
public class Championship {
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   // @NotNull
    private int qtdOfTeams;
    //@NotNull
    private int year;
    //@NotNull
    private String name;
    private List<String>  teams;
    private String phase;

    public Championship() {
        super();
    }

    public Championship(Long type, int year, String name, List<String> teams) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.teams = teams;
    }

    public int getQtdOfTeams() {
        return qtdOfTeams;
    }

    public void setQtdOfTeams(int qtdOfTeams) {
        this.qtdOfTeams = qtdOfTeams;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
}
