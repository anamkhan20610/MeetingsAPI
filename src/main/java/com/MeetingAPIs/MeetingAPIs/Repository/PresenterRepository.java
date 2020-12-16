package com.MeetingAPIs.MeetingAPIs.Repository;

import com.MeetingAPIs.MeetingAPIs.Models.SessionPresenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresenterRepository extends JpaRepository<SessionPresenter,String> {
    public SessionPresenter findByTalkTitle(String title);
}
