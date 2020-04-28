package br.com.nayaranunes.terradonunca.domain;

import java.util.List;

public class NextPhase {
    private List<Team> teams;
    private List<String> winnersNames;

    public NextPhase(List<String> winnersNames) {
        this.winnersNames = winnersNames;
    }

    public NextPhase() {
        super();
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<String> getWinnersNames() {
        return winnersNames;
    }

    public void setWinnersNames(List<String> winnersNames) {
        this.winnersNames = winnersNames;
    }
}
