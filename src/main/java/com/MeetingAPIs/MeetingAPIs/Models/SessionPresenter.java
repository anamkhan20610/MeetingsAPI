package com.MeetingAPIs.MeetingAPIs.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "presenter")
public class SessionPresenter implements Serializable {

    @Id
    private String talkPresenter;
    private String talkTitle;
    private Date talkDate;

    @Embedded
    private Address location;

    public SessionPresenter(String talkPresenter, String talkTitle, Date talkDate, Address location) {
        this.talkPresenter = talkPresenter;
        this.talkTitle = talkTitle;
        this.talkDate = talkDate;
        this.location = location;
    }

    public SessionPresenter() {
    }

    public String getTalkPresenter() { return talkPresenter; }

    public void setTalkPresenter(String talkPresenter) { this.talkPresenter = talkPresenter; }

    public String getTalkTitle() { return talkTitle; }

    public void setTalkTitle(String talkTitle) { this.talkTitle = talkTitle; }

    public Date getTalkDate() { return talkDate; }

    public void setTalkDate(Date talkDate) { this.talkDate = talkDate; }

    public Address getLocation() { return location; }

    public void setLocation(Address location) { this.location = location; }

    @Override
    public String toString() {
        return "SessionPresenter{" +
                "talkPresenter='" + talkPresenter + '\'' +
                ", talkTitle='" + talkTitle + '\'' +
                ", talkDate=" + talkDate +
                ", location=" + location +
                '}';
    }
}
