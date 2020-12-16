package com.MeetingAPIs.MeetingAPIs.Repository;

import com.MeetingAPIs.MeetingAPIs.Models.SpecificTalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificTalkRepository extends JpaRepository<SpecificTalk,String> {
    public SpecificTalk save(SpecificTalk specificTalk);
    public List<SpecificTalk> findByTalk(String talk);
    public List<SpecificTalk> findByAttendeeName(String name);
}
