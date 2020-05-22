package br.com.nayaranunes.terradonunca.model;

public class PlayerResponse {
    private String name;
    private String CPF;
    private Integer teamId;

    public PlayerResponse(String name, String CPF, Integer teamId) {
        this.name = name;
        this.CPF = CPF;
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
