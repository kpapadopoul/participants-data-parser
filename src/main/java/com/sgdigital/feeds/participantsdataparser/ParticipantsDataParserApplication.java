package com.sgdigital.feeds.participantsdataparser;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class ParticipantsDataParserApplication {
    private static final Logger LOGGER = getLogger(ParticipantsDataParserApplication.class);

    public static void main(String[] args)  {
        LOGGER.info("Starting the participant data parser");
        SpringApplication.run(ParticipantsDataParserApplication.class, args);
        LOGGER.info("Parser finished");
    }
}
