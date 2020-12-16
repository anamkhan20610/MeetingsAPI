package com.MeetingAPIs.MeetingAPIs.Repository;

import com.MeetingAPIs.MeetingAPIs.Models.ConferenceAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<ConferenceAttendee,String> {
}
