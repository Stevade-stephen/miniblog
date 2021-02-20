package com.miniblog.demo.services.serviceImpl;

import com.miniblog.demo.models.User;
import com.miniblog.demo.repositories.UserRepository;
import com.miniblog.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        // /users/3



    }


    @Override
    public User login() {
        return null;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateDetails(User user, Long userId) {
        user.setId(userId);
        userRepository.save(user);
    }

    @Override
    public void deactivate(Long userId) {
        userRepository.deleteById(userId);
    }
}
