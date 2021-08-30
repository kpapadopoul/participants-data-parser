package com.sgdigital.feeds.participantsdataparser.service;

import com.sgdigital.feeds.participantsdataparser.model.input.InputParticipantDataset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = { "app.input.path=./src/test/resources/csv" })
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ParticipantExtractServiceIntegrationTest {

    @Autowired
    private ParticipantExtractService participantExtractService;

    @Test
    void testExtract() {
        final InputParticipantDataset inputParticipantDataset = participantExtractService.extract();

        assertNotNull(inputParticipantDataset);

        assertNotNull(inputParticipantDataset.getTeamParticipants());
        assertTrue(inputParticipantDataset.getTeamParticipants().size() > 0);

        assertNotNull(inputParticipantDataset.getIndividualParticipants());
        assertTrue(inputParticipantDataset.getIndividualParticipants().size() > 0);
    }
}