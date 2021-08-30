package com.sgdigital.feeds.participantsdataparser.model.input;

import java.util.List;

public final class InputParticipantDatasetBuilder {
    private List<TeamParticipant> teamParticipants;
    private List<IndividualParticipant> individualParticipants;

    private InputParticipantDatasetBuilder() {
    }

    public static InputParticipantDatasetBuilder anInputParticipantDataset() {
        return new InputParticipantDatasetBuilder();
    }

    public InputParticipantDatasetBuilder withTeamParticipants(List<TeamParticipant> teamParticipants) {
        this.teamParticipants = teamParticipants;
        return this;
    }

    public InputParticipantDatasetBuilder withIndividualParticipants(List<IndividualParticipant> individualParticipants) {
        this.individualParticipants = individualParticipants;
        return this;
    }

    public InputParticipantDataset build() {
        InputParticipantDataset inputParticipantDataset = new InputParticipantDataset();
        inputParticipantDataset.setTeamParticipants(teamParticipants);
        inputParticipantDataset.setIndividualParticipants(individualParticipants);
        return inputParticipantDataset;
    }
}
