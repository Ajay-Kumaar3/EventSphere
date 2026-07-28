package com.projects.EventSphere.repository;

import com.projects.EventSphere.entity.Event;
import com.projects.EventSphere.entity.Feedback;
import com.projects.EventSphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository
        extends JpaRepository<Feedback, Long> {

    List<Feedback> findByEvent(Event event);

    List<Feedback> findByUser(User user);

}