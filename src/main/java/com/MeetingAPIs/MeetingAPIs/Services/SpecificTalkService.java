package com.MeetingAPIs.MeetingAPIs.Services;

import com.MeetingAPIs.MeetingAPIs.Exception.ResourceNotFoundException;
import com.MeetingAPIs.MeetingAPIs.Models.SessionPresenter;
import com.MeetingAPIs.MeetingAPIs.Models.SpecificTalk;
import com.MeetingAPIs.MeetingAPIs.Repository.PresenterRepository;
import com.MeetingAPIs.MeetingAPIs.Repository.SpecificTalkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpecificTalkService {
    @Autowired
    private SpecificTalkRepository specificTalkRepository;

    public SpecificTalk specificTalkSave(SpecificTalk specificTalk) {
        return specificTalkRepository.save(specificTalk);
    }

    public List<SpecificTalk> getAttendeesByTalk(String meetingName) {
        try {
            return specificTalkRepository.findByTalk(meetingName);
        }catch(ResourceNotFoundException e) {
            throw new ResourceNotFoundException("meeting name " + meetingName + " not found");
        }
    }

}
