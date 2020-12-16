package com.MeetingAPIs.MeetingAPIs.Services;

import com.MeetingAPIs.MeetingAPIs.Models.ConferenceAttendee;
import com.MeetingAPIs.MeetingAPIs.Repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;


    public ConferenceAttendee attendeeSave(ConferenceAttendee conferenceAttendee) {
        return attendeeRepository.save(conferenceAttendee);
    }


}
