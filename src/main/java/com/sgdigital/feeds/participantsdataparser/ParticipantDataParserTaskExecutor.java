package com.sgdigital.feeds.participantsdataparser;

import com.sgdigital.feeds.participantsdataparser.model.input.InputParticipantDataset;
import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantContainer;
import com.sgdigital.feeds.participantsdataparser.service.ParticipantExtractService;
import com.sgdigital.feeds.participantsdataparser.service.ParticipantLoadService;
import com.sgdigital.feeds.participantsdataparser.service.ParticipantTransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("!test")
@Component
public class ParticipantDataParserTaskExecutor implements CommandLineRunner {
    private final ParticipantExtractService participantExtractService;
    private final ParticipantTransformService participantTransformService;
    private final ParticipantLoadService participantLoadService;

    @Autowired
    public ParticipantDataParserTaskExecutor(
            ParticipantExtractService participantExtractService, ParticipantTransformService participantTransformService,
            ParticipantLoadService participantLoadService) {
        this.participantExtractService = participantExtractService;
        this.participantTransformService = participantTransformService;
        this.participantLoadService = participantLoadService;
    }

    @Override
    public void run(String... args) {
        // Extract
        final InputParticipantDataset inputParticipantDataset = participantExtractService.extract();

        // Transform
        final List<ParticipantContainer> participantContainers
                = participantTransformService.transform(inputParticipantDataset);

        // Load
        participantLoadService.load(participantContainers);
    }
}
