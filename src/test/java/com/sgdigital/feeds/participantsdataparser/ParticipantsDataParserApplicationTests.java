package com.sgdigital.feeds.participantsdataparser;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(properties = { "app.input.path=./src/test/resources/csv" })
class ParticipantsDataParserApplicationTests {
    @SpyBean
    private ParticipantDataParserTaskExecutor participantDataParserTaskExecutor;

    @Test
    void whenContextLoads_thenRunnersRun() {
        verify(participantDataParserTaskExecutor, times(1)).run(any());
    }
}
