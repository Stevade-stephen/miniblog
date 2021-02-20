package com.miniblog.demo.controllers;

import com.miniblog.demo.models.User;
import com.miniblog.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping("/register")
    public String registerUserGet() {
        return "register.html";
    }

    @PostMapping("/register")
    public String registerUserPost(@Valid @ModelAttribute("users") User user) {
        userService.register(user);
        return "login.html";
    }
}
