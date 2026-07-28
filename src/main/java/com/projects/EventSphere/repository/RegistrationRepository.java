package com.projects.EventSphere.repository;

import com.projects.EventSphere.entity.Event;
import com.projects.EventSphere.entity.Registration;
import com.projects.EventSphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository
        extends JpaRepository<Registration, Long> {

    List<Registration> findByUser(User user);

    List<Registration> findByEvent(Event event);

    boolean existsByUserAndEvent(User user,
                                 Event event);

}