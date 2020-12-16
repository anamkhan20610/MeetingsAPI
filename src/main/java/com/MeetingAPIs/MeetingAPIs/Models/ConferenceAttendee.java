package com.MeetingAPIs.MeetingAPIs.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AttendeeAtConference")
public class ConferenceAttendee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String company;

    @NotNull
    private String conferenceTitle;
    @NotNull
    private String attendee;

    public String getAttendee() {
        return attendee;
    }

    public void setAttendee(String attendee) {
        this.attendee = attendee;
    }

    public ConferenceAttendee(Long id, String attendee, String company, String conferenceTitle) {
        this.id = id;
        this.attendee = attendee;
        this.company = company;
        this.conferenceTitle = conferenceTitle;
    }

    public ConferenceAttendee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "name='" + attendee + '\'' +
                ", company='" + company + '\'' +
                ", title=" + conferenceTitle +
                '}';
    }
}
