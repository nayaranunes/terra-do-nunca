package br.com.nayaranunes.terradonunca.entitys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "players")
public class Player implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "players_seq")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "team_id")
    private Integer teamId;

    public Player() {
    }

    public Player(String name, String  cpf, Integer teamId) {
        this.name = name;
        this.cpf = cpf;
        this.teamId = teamId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
