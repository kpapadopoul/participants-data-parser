package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.config.InputProperties;
import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.Participant;
import com.sgdigital.feeds.participantsdataparser.model.output.SourceParticipant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SourceParticipantMapperTest {
    private final InputProperties inputProperties = mock(InputProperties.class);
    private final SourceParticipantMapper sourceParticipantMapper = new SourceParticipantMapper(inputProperties);

    @Test
    void testMap_teamParticipant() {
        final String feed = "betradar";
        final String sourceId = "sr:competitor:4233";
        final String sourceName = "Wigan Warriors";

        TeamParticipant teamParticipant = mock(TeamParticipant.class);
        when(teamParticipant.getSourceId()).thenReturn(sourceId);
        when(teamParticipant.getSourceName()).thenReturn(sourceName);

        when(inputProperties.getFeed()).thenReturn(feed);

        final SourceParticipant sourceParticipant = sourceParticipantMapper.map(teamParticipant);

        assertNotNull(sourceParticipant);
        assertEquals(feed, sourceParticipant.getParticipantSource());
        assertEquals(sourceId, sourceParticipant.getSourceParticipantId());
        assertEquals(feed, sourceParticipant.getSportSource());
        assertEquals(SourceParticipant.MATCHED_STATUS, sourceParticipant.getMatchingStatus());
        assertEquals(Participant.TEAM_TYPE, sourceParticipant.getType());
        assertEquals(sourceName, sourceParticipant.getDisplayName());
        assertEquals(Participant.TEAM_DATA, sourceParticipant.getData());
    }

    @Test
    void testMap_individualParticipant() {
        final String feed = "betradar";
        final String sourceId = "sr:player:1108537";
        final String sourceName = "Field, Jai";
        final String expectedData = "{\"type\": \"player\", \"surname\": \"Field\", \"forename\": \"Jai\"}";

        IndividualParticipant individualParticipant = mock(IndividualParticipant.class);
        when(individualParticipant.getSourceId()).thenReturn(sourceId);
        when(individualParticipant.getName()).thenReturn(sourceName);
        when(individualParticipant.getFirstName()).thenReturn("Jai");
        when(individualParticipant.getLastName()).thenReturn("Field");

        when(inputProperties.getFeed()).thenReturn(feed);

        final SourceParticipant sourceParticipant = sourceParticipantMapper.map(individualParticipant);

        assertNotNull(sourceParticipant);
        assertEquals(feed, sourceParticipant.getParticipantSource());
        assertEquals(sourceId, sourceParticipant.getSourceParticipantId());
        assertEquals(feed, sourceParticipant.getSportSource());
        assertEquals(SourceParticipant.MATCHED_STATUS, sourceParticipant.getMatchingStatus());
        assertEquals(Participant.INDIVIDUAL_TYPE, sourceParticipant.getType());
        assertEquals(sourceName, sourceParticipant.getDisplayName());
        assertEquals(expectedData, sourceParticipant.getData());
    }
}