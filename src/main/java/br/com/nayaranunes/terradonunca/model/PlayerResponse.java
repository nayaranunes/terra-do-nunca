package br.com.nayaranunes.terradonunca.model;


public class PlayerResponse {
    private String name;
    private String CPF;

    public PlayerResponse() {
        super();
    }

    public PlayerResponse(String name, String CPF) {
        this.name = name;
        this.CPF = CPF;
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
}
