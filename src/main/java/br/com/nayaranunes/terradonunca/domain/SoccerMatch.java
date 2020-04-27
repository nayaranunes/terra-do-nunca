package br.com.nayaranunes.terradonunca.domain;

public class SoccerMatch {
    private Team teamOne;
    private Team teamTwo;

    public SoccerMatch() {
        super();
    }

    public SoccerMatch(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }
}
