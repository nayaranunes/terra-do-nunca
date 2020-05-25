package br.com.nayaranunes.terradonunca.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "championships")
public class Championship implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "championship_seq")
    private Integer id;
    @Column(name = "year")
    private int year;
    @Column(name = "name")
    private String name;
    @Column(name = "phase")
    private Integer phase;

    public Championship() {
        super();
    }

    public Championship(Integer id, int year, String name, Integer phase) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.phase = phase;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase() {
        this.phase++;
    }
}
