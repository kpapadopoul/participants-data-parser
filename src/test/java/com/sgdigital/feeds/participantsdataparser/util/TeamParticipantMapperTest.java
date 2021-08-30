package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamParticipantMapperTest {
    @Test
    void map() {
        final String canonicalName = "South Carolina Gamecocks";
        final String sourceId = "4278";
        final String sourceName = "South Carolina Gamecocks";
        final String line =
                String.join(TeamParticipantMapper.COMMA, canonicalName, sourceId, sourceName);

        final TeamParticipant teamParticipant = TeamParticipantMapper.map(line);

        assertNotNull(teamParticipant);
        assertEquals(canonicalName, teamParticipant.getCanonicalName());
        assertEquals(sourceId, teamParticipant.getSourceId());
        assertEquals(sourceName, teamParticipant.getSourceName());
    }
}