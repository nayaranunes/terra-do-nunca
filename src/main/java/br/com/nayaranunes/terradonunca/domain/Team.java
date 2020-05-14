package br.com.nayaranunes.terradonunca.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


//@Entity
//@Table(name = "teams")
public class Team {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@NotNull
    private String coach;
    //@NotNull
    private String cnpj;
    //@NotNull
    private String name;
    //@NotBlank
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
