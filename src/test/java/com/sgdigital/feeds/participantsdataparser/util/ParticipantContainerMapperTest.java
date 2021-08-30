package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.Participant;
import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantContainer;
import com.sgdigital.feeds.participantsdataparser.model.output.SourceParticipant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParticipantContainerMapperTest {
    ParticipantMapper participantMapper = mock(ParticipantMapper.class);
    SourceParticipantMapper sourceParticipantMapper = mock(SourceParticipantMapper.class);
    ParticipantContainerMapper participantContainerMapper =
            new ParticipantContainerMapper(participantMapper, sourceParticipantMapper);

    @Test
    void testMap_teamParticipant() {
        TeamParticipant teamParticipant = mock(TeamParticipant.class);
        Participant participant = mock(Participant.class);
        SourceParticipant sourceParticipant = mock(SourceParticipant.class);

        when(participantMapper.map(teamParticipant)).thenReturn(participant);
        when(sourceParticipantMapper.map(teamParticipant)).thenReturn(sourceParticipant);

        final ParticipantContainer participantContainer = participantContainerMapper.map(teamParticipant);

        assertNotNull(participantContainer);
        assertEquals(participant, participantContainer.getParticipant());
        assertEquals(sourceParticipant, participantContainer.getSourceParticipant());
    }

    @Test
    void testMap_individualParticipant() {
        IndividualParticipant individualParticipant = mock(IndividualParticipant.class);
        Participant participant = mock(Participant.class);
        SourceParticipant sourceParticipant = mock(SourceParticipant.class);

        when(participantMapper.map(individualParticipant)).thenReturn(participant);
        when(sourceParticipantMapper.map(individualParticipant)).thenReturn(sourceParticipant);

        final ParticipantContainer participantContainer = participantContainerMapper.map(individualParticipant);

        assertNotNull(participantContainer);
        assertEquals(participant, participantContainer.getParticipant());
        assertEquals(sourceParticipant, participantContainer.getSourceParticipant());
    }
}
