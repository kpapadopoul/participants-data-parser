package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipantBuilder;
import org.springframework.stereotype.Component;

@Component
public class TeamParticipantMapper {
    static final String COMMA = ",";

    TeamParticipantMapper() {
        // private constructor to hide the implicit public one.
    }

    public static TeamParticipant map(String line) {
        final String[] split = line.split(COMMA);

        return TeamParticipantBuilder.aTeamParticipant()
                .withCanonicalName(split[0])
                .withSourceId(split[1])
                .withSourceName(split[2])
                .build();
    }
}
