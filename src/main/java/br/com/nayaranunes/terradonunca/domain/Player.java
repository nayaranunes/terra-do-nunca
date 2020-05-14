package br.com.nayaranunes.terradonunca.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "players")
public class Player implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name_player")
    private String namePlayer;
    @Column(name = "cpf")
    private String CPF;
    @Column(name = "has_time")
    private boolean hasTime;

    public Player() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean isHasTime() {
        return hasTime;
    }

    public void setHasTime(boolean hasTime) {
        this.hasTime = hasTime;
    }
}
