package br.com.nayaranunes.terradonunca.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "players")
public class Player implements Serializable {   //implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
  //  @NotNull
    @Column(name = "name")
    private String name;
   // @NotNull
    @Column(name = "cpf")
    private String CPF;
    @Column(name = "hasTime")
    private boolean hasTime;

    public Player() {
    }

    public Player(String name, String CPF) {
        this.name = name;
        this.CPF = CPF;
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
