package com.projects.EventSphere.serviceImpl;
import com.projects.EventSphere.dto.LoginRequest;
import com.projects.EventSphere.dto.LoginResponse;
import com.projects.EventSphere.entity.User;
import com.projects.EventSphere.repository.UserRepository;
import com.projects.EventSphere.security.JwtService;
import com.projects.EventSphere.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public User register(User user) {

        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email Already Exists");
        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        User user = userRepository.findByEmail(request.email())
                .orElseThrow();

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }

}