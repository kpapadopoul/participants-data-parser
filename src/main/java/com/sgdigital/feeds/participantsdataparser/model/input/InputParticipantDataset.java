package com.sgdigital.feeds.participantsdataparser.model.input;

import java.util.List;

public class InputParticipantDataset {
    private List<TeamParticipant> teamParticipants;
    private List<IndividualParticipant> individualParticipants;

    public List<TeamParticipant> getTeamParticipants() {
        return teamParticipants;
    }

    public void setTeamParticipants(List<TeamParticipant> teamParticipants) {
        this.teamParticipants = teamParticipants;
    }

    public List<IndividualParticipant> getIndividualParticipants() {
        return individualParticipants;
    }

    public void setIndividualParticipants(List<IndividualParticipant> individualParticipants) {
        this.individualParticipants = individualParticipants;
    }
}
