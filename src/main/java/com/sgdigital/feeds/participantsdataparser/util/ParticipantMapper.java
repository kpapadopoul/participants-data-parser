package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.Participant;
import com.sgdigital.feeds.participantsdataparser.model.output.ParticipantBuilder;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {
    public Participant map(TeamParticipant teamParticipant) {
        return ParticipantBuilder.aParticipant()
                .withSportId(null) // TODO: We need to define how we are going to get here the actual sport id.
                .withType(Participant.TEAM_TYPE)
                .withDisplayName(teamParticipant.getCanonicalName())
                .withDisplayNameVector(mapDisplayNameVector(teamParticipant))
                .withAdhoc(false)
                .withRecordStatus(Participant.ACTIVE_RECORD_STATUS)
                .build();
    }

    public Participant map(IndividualParticipant individualParticipant) {
        return ParticipantBuilder.aParticipant()
                .withSportId(null) // TODO: We need to define how we are going to get here the actual sport id.
                .withType(Participant.INDIVIDUAL_TYPE)
                .withDisplayName(individualParticipant.getName())
                .withDisplayNameVector(mapDisplayNameVector(individualParticipant))
                .withData(String.format(Participant.INDIVIDUAL_DATA,
                        individualParticipant.getLastName(), individualParticipant.getFirstName()))
                .withAdhoc(false)
                .withRecordStatus(Participant.ACTIVE_RECORD_STATUS)
                .build();
    }

    private String mapDisplayNameVector(TeamParticipant teamParticipant) {
        // TODO: We need to define how we are to going to generate the display name vector
        return null;
    }

    private String mapDisplayNameVector(IndividualParticipant individualParticipant) {
        // TODO: We need to define how we are to going to generate the display name vector
        return null;
    }
}
