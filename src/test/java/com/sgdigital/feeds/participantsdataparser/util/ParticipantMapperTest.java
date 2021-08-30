package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.Participant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParticipantMapperTest {
    ParticipantMapper participantMapper = new ParticipantMapper();

    @Test
    void testMap_teamParticipant() {
        final String canonicalName = "FC Barcelona";

        TeamParticipant teamParticipant = mock(TeamParticipant.class);
        when(teamParticipant.getCanonicalName()).thenReturn(canonicalName);

        final Participant participant = participantMapper.map(teamParticipant);

        assertNotNull(participant);
        assertEquals(Participant.TEAM_TYPE, participant.getType());
        assertEquals(canonicalName, participant.getDisplayName());
        assertFalse(participant.isAdhoc());
        assertEquals(Participant.ACTIVE_RECORD_STATUS, participant.getRecordStatus());
    }

    @Test
    void testMap_individualParticipant() {
        final String expectedParticipantData = "{\"type\": \"player\", \"surname\": \"Messi\", \"forename\": \"Leo\"}";
        final String name = "Leo Messi";

        IndividualParticipant individualParticipant = mock(IndividualParticipant.class);
        when(individualParticipant.getFirstName()).thenReturn("Leo");
        when(individualParticipant.getLastName()).thenReturn("Messi");
        when(individualParticipant.getName()).thenReturn(name);

        final Participant participant = participantMapper.map(individualParticipant);

        assertNotNull(participant);
        assertEquals(Participant.INDIVIDUAL_TYPE, participant.getType());
        assertEquals(name, participant.getDisplayName());
        assertEquals(expectedParticipantData, participant.getData());
        assertFalse(participant.isAdhoc());
        assertEquals(Participant.ACTIVE_RECORD_STATUS, participant.getRecordStatus());
    }
}