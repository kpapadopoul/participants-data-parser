package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantContainer;
import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantContainerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipantContainerMapper {
    private final ParticipantMapper participantMapper;
    private final SourceParticipantMapper sourceParticipantMapper;

    @Autowired
    public ParticipantContainerMapper(ParticipantMapper participantMapper, SourceParticipantMapper sourceParticipantMapper) {
        this.participantMapper = participantMapper;
        this.sourceParticipantMapper = sourceParticipantMapper;
    }

    public ParticipantContainer map(TeamParticipant teamParticipant) {
        return ParticipantContainerBuilder.aParticipantContainer()
                .withParticipant(participantMapper.map(teamParticipant))
                .withSourceParticipant(sourceParticipantMapper.map(teamParticipant))
                .build();
    }

    public ParticipantContainer map(IndividualParticipant individualParticipant) {
        return ParticipantContainerBuilder.aParticipantContainer()
                .withParticipant(participantMapper.map(individualParticipant))
                .withSourceParticipant(sourceParticipantMapper.map(individualParticipant))
                .build();
    }
}
