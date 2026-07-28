package com.projects.EventSphere.service;

import com.projects.EventSphere.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback submitFeedback(
            Long userId,
            Long eventId,
            Feedback feedback
    );

    List<Feedback> getFeedbackByEvent(Long eventId);

}
