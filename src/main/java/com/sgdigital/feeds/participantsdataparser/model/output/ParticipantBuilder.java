package com.sgdigital.feeds.participantsdataparser.model.output;

public final class ParticipantBuilder {
    private Long participantId;
    private Long sportId;
    private String type;
    private String displayName;
    private String displayNameVector;
    private String data;
    private boolean adhoc;
    private String recordStatus;

    private ParticipantBuilder() {
    }

    public static ParticipantBuilder aParticipant() {
        return new ParticipantBuilder();
    }

    public ParticipantBuilder withParticipantId(Long participantId) {
        this.participantId = participantId;
        return this;
    }

    public ParticipantBuilder withSportId(Long sportId) {
        this.sportId = sportId;
        return this;
    }

    public ParticipantBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ParticipantBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ParticipantBuilder withDisplayNameVector(String displayNameVector) {
        this.displayNameVector = displayNameVector;
        return this;
    }

    public ParticipantBuilder withData(String data) {
        this.data = data;
        return this;
    }

    public ParticipantBuilder withAdhoc(boolean adhoc) {
        this.adhoc = adhoc;
        return this;
    }

    public ParticipantBuilder withRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
        return this;
    }

    public Participant build() {
        Participant participant = new Participant();
        participant.setParticipantId(participantId);
        participant.setSportId(sportId);
        participant.setType(type);
        participant.setDisplayName(displayName);
        participant.setDisplayNameVector(displayNameVector);
        participant.setData(data);
        participant.setAdhoc(adhoc);
        participant.setRecordStatus(recordStatus);
        return participant;
    }
}
