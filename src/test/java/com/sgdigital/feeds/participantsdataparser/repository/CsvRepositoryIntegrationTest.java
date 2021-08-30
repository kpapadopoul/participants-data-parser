package com.sgdigital.feeds.participantsdataparser.repository;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.util.IndividualParticipantMapper;
import com.sgdigital.feeds.participantsdataparser.util.TeamParticipantMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CsvRepositoryIntegrationTest {

    @Autowired
    private CsvRepository csvRepository;

    @Test
    void testReadAll_teamParticipants() {
        final String inputPath = "./src/test/resources/csv/team";

        final List<TeamParticipant> teamParticipants = csvRepository.reaAll(inputPath, TeamParticipantMapper::map);

        assertNotNull(teamParticipants);
        assertTrue(teamParticipants.size() > 0);
    }

    @Test
    void testReadAll_individualParticipants() {
        final String inputPath = "./src/test/resources/csv/individual";

        final List<IndividualParticipant> individualParticipants
                = csvRepository.reaAll(inputPath, IndividualParticipantMapper::map);

        assertNotNull(individualParticipants);
        assertTrue(individualParticipants.size() > 0);
    }

    @Test
    void testRead_teamParticipants() {
        final String inputFilePath = "./src/test/resources/csv/team/American Football.csv";

        final List<TeamParticipant> teamParticipants = csvRepository.read(inputFilePath, TeamParticipantMapper::map);

        assertNotNull(teamParticipants);
        assertTrue(teamParticipants.size() > 0);
    }

    @Test
    void testRead_individualParticipants() {
        final String inputFilePath = "./src/test/resources/csv/individual/American Football.csv";

        final List<IndividualParticipant> individualParticipantList =
                csvRepository.read(inputFilePath, IndividualParticipantMapper::map);

        assertNotNull(individualParticipantList);
        assertTrue(individualParticipantList.size() > 0);
    }

    @Test
    void testListFiles() {
        final String inputPath = "./src/test/resources/csv/team";

        final List<String> files = csvRepository.listFiles(inputPath);

        assertNotNull(files);
        assertTrue(files.size() > 0);
        assertEquals(2, files.size());
    }
}