package com.sgdigital.feeds.participantsdataparser.model.output;

public final class ParticipantContainerBuilder {
    private Participant participant;
    private SourceParticipant sourceParticipant;

    private ParticipantContainerBuilder() {
    }

    public static ParticipantContainerBuilder aParticipantContainer() {
        return new ParticipantContainerBuilder();
    }

    public ParticipantContainerBuilder withParticipant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public ParticipantContainerBuilder withSourceParticipant(SourceParticipant sourceParticipant) {
        this.sourceParticipant = sourceParticipant;
        return this;
    }

    public ParticipantContainer build() {
        ParticipantContainer participantContainer = new ParticipantContainer();
        participantContainer.setParticipant(participant);
        participantContainer.setSourceParticipant(sourceParticipant);
        return participantContainer;
    }
}
