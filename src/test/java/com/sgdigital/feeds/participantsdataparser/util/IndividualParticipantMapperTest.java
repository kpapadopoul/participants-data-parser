package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividualParticipantMapperTest {
    @Test
    void map() {
        final String name = "De'Vante Bausby";
        final String firstName = "De'Vante";
        final String lastName = "Bausby";
        final String sourceId = "944420";
        final String line =
                String.join(IndividualParticipantMapper.COMMA, name, firstName, lastName, sourceId);

        final IndividualParticipant individualParticipant = IndividualParticipantMapper.map(line);

        assertNotNull(individualParticipant);
        assertEquals(name, individualParticipant.getName());
        assertEquals(firstName, individualParticipant.getFirstName());
        assertEquals(lastName, individualParticipant.getLastName());
        assertEquals(sourceId, individualParticipant.getSourceId());
    }
}