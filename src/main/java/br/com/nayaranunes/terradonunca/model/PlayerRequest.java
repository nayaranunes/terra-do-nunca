package br.com.nayaranunes.terradonunca.model;

import org.hibernate.validator.constraints.br.CPF;

public class PlayerRequest {
    //usuariooo
    private String name;
    @CPF
    private String cpf;

    public PlayerRequest(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    PlayerRequest(){
        super();
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
