package com.kaishengit.entity;

public class Movie {
    private Integer id;
    private String title;
    private float rate;
    private String releaseYear;
    private String sendTime;
    private String director;
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rate=" + rate +
                ", releaseYear='" + releaseYear + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
