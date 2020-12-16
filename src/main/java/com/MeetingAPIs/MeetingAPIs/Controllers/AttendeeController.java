package com.MeetingAPIs.MeetingAPIs.Controllers;

import com.MeetingAPIs.MeetingAPIs.Models.ConferenceAttendee;
import com.MeetingAPIs.MeetingAPIs.Models.SessionPresenter;
import com.MeetingAPIs.MeetingAPIs.Models.SpecificTalk;
import com.MeetingAPIs.MeetingAPIs.Services.AttendeeService;
import com.MeetingAPIs.MeetingAPIs.Services.PresenterService;
import com.MeetingAPIs.MeetingAPIs.Services.SpecificTalkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;
    @Autowired
    private PresenterService presenterService;
    @Autowired
    private SpecificTalkService specificTalkService;

    @PostMapping("/register/conference")
    public ResponseEntity registerToConference(@RequestBody ConferenceAttendee conferenceAttendee){
        System.out.println("object ====="+ conferenceAttendee.getAttendee());

        ConferenceAttendee conferenceAttendee1 = attendeeService.attendeeSave(conferenceAttendee);
        if(conferenceAttendee1 == null)
            return ResponseEntity.badRequest()
                    .body("Check logs, error saving data for the attendee");

        return new ResponseEntity<>(conferenceAttendee1, HttpStatus.OK);
    }

    @PostMapping("/register/presenter")
    public ResponseEntity registerPresenter(@RequestBody SessionPresenter presenter){
        SessionPresenter sessionPresenter = presenterService.presenterSave(presenter);
        if(sessionPresenter == null)
            return ResponseEntity.badRequest()
                    .body("Check logs, error saving data for the presenter");

        return new ResponseEntity<>("data saved successfully", HttpStatus.OK);
    }

    @PostMapping("/register/specificTalk")
    public ResponseEntity registerToSpecificTalk(@RequestBody SpecificTalk specificTalk){
        SpecificTalk specificTalkObj = specificTalkService.specificTalkSave(specificTalk);
        if(specificTalkObj == null)
            return ResponseEntity.badRequest()
                    .body("Check logs, error saving data for the specific talk");

        return new ResponseEntity<>("data saved successfully", HttpStatus.OK);
    }

    @GetMapping("/attendee/{meetingName}")
    public ResponseEntity getAttendeesByTalk(@PathVariable String meetingName){
        List<SpecificTalk> data = specificTalkService.getAttendeesByTalk(meetingName);
        if(data == null)
            return ResponseEntity.badRequest()
                    .body("Check logs, error getting data");

        return new ResponseEntity<>(data, HttpStatus.OK);}

    @GetMapping("/schedule/{attendeeName}")
    public ResponseEntity getSchedule(@PathVariable String attendeeName){
        List<SessionPresenter> schedule = presenterService.getSchedule(attendeeName);
        if(schedule == null)
            return ResponseEntity.badRequest()
                    .body("Check logs, error getting data");

        return new ResponseEntity<>(schedule, HttpStatus.OK);}
}
