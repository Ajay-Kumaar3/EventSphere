package com.projects.EventSphere.service;

import com.projects.EventSphere.entity.Registration;

import java.util.List;

public interface RegistrationService {

    Registration register(Long userId, Long eventId);

    void cancelRegistration(Long registrationId);

    List<Registration> getRegistrationsByUser(Long userId);

}