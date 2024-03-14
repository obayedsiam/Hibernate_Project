package com.tut.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

    //    @Column(name = "COURSE")
    private String course;

    //    @Column(name = "DURATION")
    private String duration;

    public Certificate(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }

    public Certificate() {
        super();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
