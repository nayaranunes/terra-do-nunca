package br.com.nayaranunes.terradonunca.model;

import br.com.nayaranunes.terradonunca.domain.Player;

import java.util.List;

public class TeamResponse {
    private String coach;
    private String cnpj;
    private String name;
  //  private List<String> listOfPlayersCPF;
    private List<Player> listOfPlayers;

    public TeamResponse() {
        super();
    }

    public TeamResponse(String coach, String cnpj,
                       String name, List<Player> listOfPlayers) {
        this.coach = coach;
        this.cnpj = cnpj;
        this.name = name;
        this.listOfPlayers = listOfPlayers;
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
/*
    public List<String> getListOfPlayersCPF() {
        return listOfPlayersCPF;
    }

    public void setListOfPlayersCPF(List<String> listOfPlayersCPF) {
        this.listOfPlayersCPF = listOfPlayersCPF;
    }
*/
    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

}