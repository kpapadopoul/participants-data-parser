package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipantBuilder;
import org.springframework.stereotype.Component;

@Component
public class IndividualParticipantMapper {
    static final String COMMA = ",";

    IndividualParticipantMapper() {
        // private constructor to hide the implicit public one.
    }

    public static IndividualParticipant map(String line) {
        final String[] split = line.split(COMMA);

        return IndividualParticipantBuilder.anIndividualParticipant()
                .withName(split[0])
                .withFirstName(split[1])
                .withLastName(split[2])
                .withSourceId(split[3])
                .build();
    }
}
