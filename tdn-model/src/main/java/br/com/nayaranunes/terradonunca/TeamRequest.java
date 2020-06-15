package br.com.nayaranunes.terradonunca;

import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

public class TeamRequest {

    public Integer championshipId;
    private String coach;
    @CNPJ
    private String cnpj;
    private String name;

    public TeamRequest() {
        super();
    }

    public TeamRequest(String coach, String cnpj,
                       String name, Integer championshipId) {
        this.coach = coach;
        this.cnpj = cnpj;
        this.name = name;
        this.championshipId = championshipId;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(Integer championshipId) {
        this.championshipId = championshipId;
    }

}
