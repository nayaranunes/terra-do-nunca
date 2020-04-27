package br.com.nayaranunes.terradonunca.domain;

import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

public class Team {

    private Long id;
    private String coach;
    private String cnpj;
    private String name;
    private List<String> listOfPlayersCPF;
    private List<Player> listOfPlayers;

    public Team() {
        super();
    }

    public Team(Long id, String coach, String cnpj,
                String name, List<String> listOfPlayersCPF) {
        this.id = id;
        this.coach = coach;
        this.cnpj = cnpj;
        this.name = name;
        this.listOfPlayersCPF = listOfPlayersCPF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListOfPlayersCPF() {
        return listOfPlayersCPF;
    }

    public void setListOfPlayersCPF(List<String> listOfPlayersCPF) {
        this.listOfPlayersCPF = listOfPlayersCPF;
    }

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
}
