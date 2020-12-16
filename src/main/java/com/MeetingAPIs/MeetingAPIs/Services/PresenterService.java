package com.MeetingAPIs.MeetingAPIs.Services;

import com.MeetingAPIs.MeetingAPIs.Exception.ResourceNotFoundException;
import com.MeetingAPIs.MeetingAPIs.Models.SessionPresenter;
import com.MeetingAPIs.MeetingAPIs.Repository.PresenterRepository;
import com.MeetingAPIs.MeetingAPIs.Repository.SpecificTalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresenterService {
    @Autowired
    private PresenterRepository presenterRepository;

    @Autowired
    private SpecificTalkRepository specificTalkRepository;

    public SessionPresenter presenterSave(SessionPresenter presenter) {
        return presenterRepository.save(presenter);
    }

    public List<SessionPresenter> getSchedule(String name){
        try {
            return specificTalkRepository.findByAttendeeName(name).stream().map(title -> {
                return presenterRepository.findByTalkTitle(title.getTalk());
            }).collect(Collectors.toList());

        }catch(ResourceNotFoundException e) {
            throw new ResourceNotFoundException("attendee " + name + " not found");
        }
    }
}
