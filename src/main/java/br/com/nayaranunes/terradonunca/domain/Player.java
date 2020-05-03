package br.com.nayaranunes.terradonunca.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "player")
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String CPF;
    private boolean hasTime;
    //MASTER bd DOMINIO

    public Player() {
        super();
    }

    public Player(Long id, String name, String CPF) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return hasTime == player.hasTime &&
                id.equals(player.id) &&
                Objects.equals(name, player.name) &&
                Objects.equals(CPF, player.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, CPF, hasTime);
    }
}
