package com.sgdigital.feeds.participantsdataparser.model.output;

public final class SourceParticipantBuilder {
    private String participantSource;
    private String sourceParticipantId;
    private String sportSource;
    private String sourceSportId;
    private Long participantId;
    private String matchingStatus;
    private String type;
    private String displayName;
    private String data;

    private SourceParticipantBuilder() {
    }

    public static SourceParticipantBuilder aSourceParticipant() {
        return new SourceParticipantBuilder();
    }

    public SourceParticipantBuilder withParticipantSource(String participantSource) {
        this.participantSource = participantSource;
        return this;
    }

    public SourceParticipantBuilder withSourceParticipantId(String sourceParticipantId) {
        this.sourceParticipantId = sourceParticipantId;
        return this;
    }

    public SourceParticipantBuilder withSportSource(String sportSource) {
        this.sportSource = sportSource;
        return this;
    }

    public SourceParticipantBuilder withSourceSportId(String sourceSportId) {
        this.sourceSportId = sourceSportId;
        return this;
    }

    public SourceParticipantBuilder withParticipantId(Long participantId) {
        this.participantId = participantId;
        return this;
    }

    public SourceParticipantBuilder withMatchingStatus(String matchingStatus) {
        this.matchingStatus = matchingStatus;
        return this;
    }

    public SourceParticipantBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public SourceParticipantBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public SourceParticipantBuilder withData(String data) {
        this.data = data;
        return this;
    }

    public SourceParticipant build() {
        SourceParticipant sourceParticipant = new SourceParticipant();
        sourceParticipant.setParticipantSource(participantSource);
        sourceParticipant.setSourceParticipantId(sourceParticipantId);
        sourceParticipant.setSportSource(sportSource);
        sourceParticipant.setSourceSportId(sourceSportId);
        sourceParticipant.setParticipantId(participantId);
        sourceParticipant.setMatchingStatus(matchingStatus);
        sourceParticipant.setType(type);
        sourceParticipant.setDisplayName(displayName);
        sourceParticipant.setData(data);
        return sourceParticipant;
    }
}
