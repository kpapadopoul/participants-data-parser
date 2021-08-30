package com.sgdigital.feeds.participantsdataparser.service;

import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantContainer;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ParticipantLoadService {
    private static final Logger LOGGER = getLogger(ParticipantLoadService.class);

    public void load(List<ParticipantContainer> participantContainers) {
        LOGGER.info("Load...");

        // TODO: Update this with the actual load functionality
        // For each participant container, we will follow the following steps:
        // 1. Insert the participant to the EC DB
        // 2. Get the auto-generated participant id
        // 3. Set the aforementioned id to the source participant
        // 4. Insert the source participant to the EC DB
    }
}
