package com.ironyard.inspo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by reevamerchant on 10/28/16.
 */
public class BollywoodSongs {

    @JsonProperty(value = "Title")
    private String title;

    @JsonProperty(value = "YouTubeLink")
    private String youTubeLink;

    @JsonProperty(value = "YouTubeEmbed")
    private String youTubeEmbed;

    @JsonProperty(value = "Id")
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYouTubeLink() {
        return youTubeLink;
    }

    public void setYouTubeLink(String youTubeLink) {
        this.youTubeLink = youTubeLink;
    }

    public String getYouTubeEmbed() {
        return youTubeEmbed;
    }

    public void setYouTubeEmbed(String youTubeEmbed) {
        this.youTubeEmbed = youTubeEmbed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
