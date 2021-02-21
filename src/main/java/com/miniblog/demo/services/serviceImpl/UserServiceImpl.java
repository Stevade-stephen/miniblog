package com.miniblog.demo.services.serviceImpl;

import com.miniblog.demo.dtos.LoginDto;
import com.miniblog.demo.dtos.ResponseDto;
import com.miniblog.demo.models.User;
import com.miniblog.demo.repositories.UserRepository;
import com.miniblog.demo.services.UserService;
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
    public ResponseDto register(LoginDto loginDto) {
        var response = new ResponseDto();
        try{
            var userInDb =  userRepository.findUserByUsername(loginDto.getUsername());
            if(userInDb != null){
                throw  new Exception("User Already Exists");
            }
            var user = new User();
            user.setUsername(loginDto.getUsername());
            user.setPassword(loginDto.getPassword());
            var registeredUser =  userRepository.save(user);
            if(registeredUser != null){
                response.setStatus(201);
                response.setSuccessful(true);
                response.setData(registeredUser);
                return  response;
            }else{
                throw new Exception("Something went wrong");
            }
        }catch (Exception e){
            response.setStatus(500);
            response.setSuccessful(false);
            response.setData(null);
            response.setError(e.getMessage());
            return response;
        }
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
