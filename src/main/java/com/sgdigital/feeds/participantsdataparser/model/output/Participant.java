package com.sgdigital.feeds.participantsdataparser.model.output;

public class Participant {
    public static final String TEAM_TYPE = "TEAM";
    public static final String INDIVIDUAL_TYPE = "INDIVIDUAL";
    public static final String ACTIVE_RECORD_STATUS = "ACTIVE";
    public static final String TEAM_DATA = "{\"tags\": {}, \"type\": \"team\"}";
    public static final String INDIVIDUAL_DATA = "{\"type\": \"player\", \"surname\": \"%s\", \"forename\": \"%s\"}";

    private Long participantId;
    private Long sportId;
    private String type;
    private String displayName;
    private String displayNameVector;
    private String data;
    private boolean adhoc;
    private String recordStatus;

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
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

    public String getDisplayNameVector() {
        return displayNameVector;
    }

    public void setDisplayNameVector(String displayNameVector) {
        this.displayNameVector = displayNameVector;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isAdhoc() {
        return adhoc;
    }

    public void setAdhoc(boolean adhoc) {
        this.adhoc = adhoc;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
