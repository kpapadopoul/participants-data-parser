package com.sgdigital.feeds.participantsdataparser.model.output;

public class SourceParticipant {
    public static final String MATCHED_STATUS = "MATCHED";

    private String participantSource;
    private String sourceParticipantId;
    private String sportSource;
    private String sourceSportId;
    private Long participantId;
    private String matchingStatus;
    private String type;
    private String displayName;
    private String data;

    public String getParticipantSource() {
        return participantSource;
    }

    public void setParticipantSource(String participantSource) {
        this.participantSource = participantSource;
    }

    public String getSourceParticipantId() {
        return sourceParticipantId;
    }

    public void setSourceParticipantId(String sourceParticipantId) {
        this.sourceParticipantId = sourceParticipantId;
    }

    public String getSportSource() {
        return sportSource;
    }

    public void setSportSource(String sportSource) {
        this.sportSource = sportSource;
    }

    public String getSourceSportId() {
        return sourceSportId;
    }

    public void setSourceSportId(String sourceSportId) {
        this.sourceSportId = sourceSportId;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getMatchingStatus() {
        return matchingStatus;
    }

    public void setMatchingStatus(String matchingStatus) {
        this.matchingStatus = matchingStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
