package com.projects.EventSphere.service;
import com.projects.EventSphere.dto.LoginRequest;
import com.projects.EventSphere.dto.LoginResponse;
import com.projects.EventSphere.entity.User;

import java.util.List;

public interface UserService {

    User register(User user);

    LoginResponse login(LoginRequest request);



}