package com.sgdigital.feeds.participantsdataparser.service;

import com.sgdigital.feeds.participantsdataparser.config.InputProperties;
import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.InputParticipantDataset;
import com.sgdigital.feeds.participantsdataparser.model.input.InputParticipantDatasetBuilder;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.repository.CsvRepository;
import com.sgdigital.feeds.participantsdataparser.util.IndividualParticipantMapper;
import com.sgdigital.feeds.participantsdataparser.util.TeamParticipantMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ParticipantExtractService {
    private static final Logger LOGGER = getLogger(ParticipantExtractService.class);

    private final CsvRepository csvRepository;
    private final InputProperties inputProperties;

    @Autowired
    public ParticipantExtractService(CsvRepository csvRepository, InputProperties inputProperties) {
        this.csvRepository = csvRepository;
        this.inputProperties = inputProperties;
    }

    public InputParticipantDataset extract() {
        LOGGER.info("Extract...");

        // Extract team participants
        final List<TeamParticipant> teamParticipants = csvRepository.reaAll(
                Paths.get(inputProperties.getPath(), inputProperties.getTeamParticipantPath()).toString(),
                TeamParticipantMapper::map);
        LOGGER.info("Extracted {} team participants", teamParticipants.size());

        // Extract individual participants
        final List<IndividualParticipant> individualParticipants = csvRepository.reaAll(
                Paths.get(inputProperties.getPath(), inputProperties.getIndividualParticipantPath()).toString(),
                IndividualParticipantMapper::map);
        LOGGER.info("Extracted {} individual participants", individualParticipants.size());

        // Return input participant dataset
        return InputParticipantDatasetBuilder.anInputParticipantDataset()
                .withTeamParticipants(teamParticipants)
                .withIndividualParticipants(individualParticipants)
                .build();
    }
}
