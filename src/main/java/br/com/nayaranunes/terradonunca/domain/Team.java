package br.com.nayaranunes.terradonunca.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teams")
public class Team implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "teams_seq")
    private Integer id;
    @Column(name = "coach")
    private String coach;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "name")
    private String name;
    @Column(name = "championship_id")
    private Integer championshipId;
    @Column(name = "status")
    private Integer status;

    public Team() {
        super();
    }

    public Team(String coach, String cnpj,
                String name, Integer championshipId) {
        this.coach = coach;
        this.cnpj = cnpj;
        this.name = name;
        this.championshipId = championshipId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(Integer championshipId) {
        this.championshipId = championshipId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus() {
        this.status++;
    }
}
