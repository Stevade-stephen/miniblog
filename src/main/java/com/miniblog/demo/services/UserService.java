package com.miniblog.demo.services;

import com.miniblog.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User login();

    User register(User user);

    void updateDetails(User user, Long userId);

    void deactivate(Long userId);
}
