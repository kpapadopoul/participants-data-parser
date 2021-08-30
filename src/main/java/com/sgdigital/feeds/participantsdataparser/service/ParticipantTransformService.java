package com.sgdigital.feeds.participantsdataparser.service;

import com.sgdigital.feeds.participantsdataparser.model.input.InputParticipantDataset;
import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantContainer;
import com.sgdigital.feeds.participantsdataparser.util.ParticipantContainerMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ParticipantTransformService {
    private static final Logger LOGGER = getLogger(ParticipantTransformService.class);

    private final ParticipantContainerMapper participantContainerMapper;

    @Autowired
    public ParticipantTransformService(ParticipantContainerMapper participantContainerMapper) {
        this.participantContainerMapper = participantContainerMapper;
    }

    public List<ParticipantContainer> transform(InputParticipantDataset inputParticipantDataset) {
        LOGGER.info("Transform...");

        final Stream<ParticipantContainer> teamParticipantContainerStream = inputParticipantDataset
                .getTeamParticipants()
                .stream()
                .map(participantContainerMapper::map);

        final Stream<ParticipantContainer> individualParticipantContainerStream = inputParticipantDataset
                .getIndividualParticipants()
                .stream()
                .map(participantContainerMapper::map);

        return Stream.concat(teamParticipantContainerStream, individualParticipantContainerStream)
                .collect(Collectors.toList());
    }
}
