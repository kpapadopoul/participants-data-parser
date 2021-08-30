package com.sgdigital.feeds.participantsdataparser.util;

import com.sgdigital.feeds.participantsdataparser.config.InputProperties;
import com.sgdigital.feeds.participantsdataparser.model.input.IndividualParticipant;
import com.sgdigital.feeds.participantsdataparser.model.input.TeamParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.Participant;
import com.sgdigital.feeds.participantsdataparser.model.output.SourceParticipant;
import com.sgdigital.feeds.participantsdataparser.model.output.SourceParticipantBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SourceParticipantMapper {
    private final InputProperties inputProperties;

    @Autowired
    public SourceParticipantMapper(InputProperties inputProperties) {
        this.inputProperties = inputProperties;
    }

    public SourceParticipant map(TeamParticipant teamParticipant) {
        // TODO: Set source participant fields based on input object fields
        return SourceParticipantBuilder.aSourceParticipant()
                .withParticipantSource(inputProperties.getFeed())
                .withSourceParticipantId(teamParticipant.getSourceId())
                .withSportSource(inputProperties.getFeed())
                .withSourceSportId(null) // TODO: We need to define how we are going to get this value
                .withMatchingStatus(SourceParticipant.MATCHED_STATUS)
                .withType(Participant.TEAM_TYPE)
                .withDisplayName(teamParticipant.getSourceName())
                .withData(Participant.TEAM_DATA)
                .build();
    }

    public SourceParticipant map(IndividualParticipant individualParticipant) {
        // TODO: Set source participant fields based on input object fields
        return SourceParticipantBuilder.aSourceParticipant()
                .withParticipantSource(inputProperties.getFeed())
                .withSourceParticipantId(individualParticipant.getSourceId())
                .withSportSource(inputProperties.getFeed())
                .withSourceSportId(null) // TODO: We need to define how we are going to get this value
                .withMatchingStatus(SourceParticipant.MATCHED_STATUS)
                .withType(Participant.INDIVIDUAL_TYPE)
                .withDisplayName(individualParticipant.getName())
                .withData(String.format(Participant.INDIVIDUAL_DATA,
                        individualParticipant.getLastName(), individualParticipant.getFirstName()))
                .build();
    }
}
