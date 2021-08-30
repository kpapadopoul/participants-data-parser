package com.sgdigital.feeds.participantsdataparser.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.input")
public class InputProperties {
    private String feed;
    private String path;
    private String teamParticipantPath;
    private String individualParticipantPath;

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTeamParticipantPath() {
        return teamParticipantPath;
    }

    public void setTeamParticipantPath(String teamParticipantPath) {
        this.teamParticipantPath = teamParticipantPath;
    }

    public String getIndividualParticipantPath() {
        return individualParticipantPath;
    }

    public void setIndividualParticipantPath(String individualParticipantPath) {
        this.individualParticipantPath = individualParticipantPath;
    }
}
