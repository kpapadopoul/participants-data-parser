package com.sgdigital.feeds.participantsdataparser.service;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.InputParticipantDataset;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantContainer;
import com.sgdigital.feeds.participantsdataparser.util.ParticipantContainerMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParticipantTransformServiceTest {
    private final ParticipantContainerMapper participantContainerMapper = mock(ParticipantContainerMapper.class);
    private final ParticipantTransformService participantTransformService
            = new ParticipantTransformService(participantContainerMapper);

    @Test
    void testTransform() {
        TeamParticipant teamParticipant1 = mock(TeamParticipant.class);
        TeamParticipant teamParticipant2 = mock(TeamParticipant.class);

        IndividualParticipant individualParticipant1 = mock(IndividualParticipant.class);
        IndividualParticipant individualParticipant2 = mock(IndividualParticipant.class);

        InputParticipantDataset inputParticipantDataset = mock(InputParticipantDataset.class);
        when(inputParticipantDataset.getTeamParticipants())
                .thenReturn(Arrays.asList(teamParticipant1, teamParticipant2));
        when(inputParticipantDataset.getIndividualParticipants())
                .thenReturn(Arrays.asList(individualParticipant1, individualParticipant2));

        final List<ParticipantContainer> participantContainers
                = participantTransformService.transform(inputParticipantDataset);

        assertNotNull(participantContainers);
        assertEquals(4, participantContainers.size());
    }
}