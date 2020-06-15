package br.com.nayaranunes.terradonunca;

import org.hibernate.validator.constraints.br.CPF;

public class PlayerRequest {
    private String name;
    @CPF
    private String cpf;
    private Integer team_id;

    public PlayerRequest(String name, String cpf, Integer team_id) {
        this.name = name;
        this.cpf = cpf;
        this.team_id = team_id;
    }

    public PlayerRequest(){
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }
}
