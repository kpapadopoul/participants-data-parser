package com.sgdigital.feeds.participantsdataparser.model.input;

public final class TeamParticipantBuilder {
    private String canonicalName;
    private String sourceId;
    private String sourceName;

    private TeamParticipantBuilder() {
    }

    public static TeamParticipantBuilder aTeamParticipant() {
        return new TeamParticipantBuilder();
    }

    public TeamParticipantBuilder withCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
        return this;
    }

    public TeamParticipantBuilder withSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public TeamParticipantBuilder withSourceName(String sourceName) {
        this.sourceName = sourceName;
        return this;
    }

    public TeamParticipant build() {
        TeamParticipant teamParticipant = new TeamParticipant();
        teamParticipant.setCanonicalName(canonicalName);
        teamParticipant.setSourceId(sourceId);
        teamParticipant.setSourceName(sourceName);
        return teamParticipant;
    }
}
