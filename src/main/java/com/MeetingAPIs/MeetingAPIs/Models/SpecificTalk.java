package com.MeetingAPIs.MeetingAPIs.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "specificMeeting")
public class SpecificTalk implements Serializable {

   @Id
   private String attendeeName;
   private String talk;

   public SpecificTalk(String attendeeName, String talk) {
        this.attendeeName = attendeeName;
        this.talk = talk;
   }

    public SpecificTalk() {}

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    @Override
    public String toString() {
        return "SpecificTalk{" +
                "attendeeName='" + attendeeName + '\'' +
                ", talk='" + talk + '\'' +
                '}';
    }
}
