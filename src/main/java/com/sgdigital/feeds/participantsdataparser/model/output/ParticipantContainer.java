package com.sgdigital.feeds.participantsdataparser.model.output;

public class ParticipantContainer {
    private Participant participant;
    private SourceParticipant sourceParticipant;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public SourceParticipant getSourceParticipant() {
        return sourceParticipant;
    }

    public void setSourceParticipant(SourceParticipant sourceParticipant) {
        this.sourceParticipant = sourceParticipant;
    }
}
