package com.sgdigital.feeds.participantsdataparser.model.input;

public final class IndividualParticipantBuilder {
    private String name;
    private String firstName;
    private String lastName;
    private String sourceId;

    private IndividualParticipantBuilder() {
    }

    public static IndividualParticipantBuilder anIndividualParticipant() {
        return new IndividualParticipantBuilder();
    }

    public IndividualParticipantBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public IndividualParticipantBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public IndividualParticipantBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public IndividualParticipantBuilder withSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public IndividualParticipant build() {
        IndividualParticipant individualParticipant = new IndividualParticipant();
        individualParticipant.setName(name);
        individualParticipant.setFirstName(firstName);
        individualParticipant.setLastName(lastName);
        individualParticipant.setSourceId(sourceId);
        return individualParticipant;
    }
}
