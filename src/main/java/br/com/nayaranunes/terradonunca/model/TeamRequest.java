package br.com.nayaranunes.terradonunca.model;

import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

public class TeamRequest {

    private String coach;
    @CNPJ
    private String cnpj;
    private String name;
    private List<String> listOfPlayersCPF;
    //private List<Player> listOfPlayers;

    public TeamRequest() {
        super();
    }

    public TeamRequest(String coach, String cnpj,
                       String name, List<String> listOfPlayersCPF) {
        this.coach = coach;
        this.cnpj = cnpj;
        this.name = name;
        this.listOfPlayersCPF = listOfPlayersCPF;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListOfPlayersCPF(){
        return listOfPlayersCPF;
    }

    public void setListOfPlayersCPF(List<String> listOfPlayersCPF) {
        this.listOfPlayersCPF = listOfPlayersCPF;
    }
/*
    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

 */
}
