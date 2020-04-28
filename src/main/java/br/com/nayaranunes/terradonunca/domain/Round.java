package br.com.nayaranunes.terradonunca.domain;

import java.util.List;

public class Round {
    private NextPhase nextPhase;
    private List<SoccerMatch> listMatches;

    public Round(NextPhase nextPhase, List<SoccerMatch> listMatches) {
        this.nextPhase = nextPhase;
        this.listMatches = listMatches;
    }

    public NextPhase getNextPhase() {
        return nextPhase;
    }

    public void setNextPhase(NextPhase nextPhase) {
        this.nextPhase = nextPhase;
    }

    public List<SoccerMatch> getListMatches() {
        return listMatches;
    }

    public void setListMatches(List<SoccerMatch> listMatches) {
        this.listMatches = listMatches;
    }
}
