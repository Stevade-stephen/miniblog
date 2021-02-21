package com.miniblog.demo.services;

import com.miniblog.demo.dtos.LoginDto;
import com.miniblog.demo.dtos.ResponseDto;
import com.miniblog.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User login();

    ResponseDto register(LoginDto loginDto);

    void updateDetails(User user, Long userId);

    void deactivate(Long userId);
}
