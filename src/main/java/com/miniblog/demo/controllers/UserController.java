package com.miniblog.demo.controllers;

import com.miniblog.demo.dtos.LoginDto;
import com.miniblog.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUserGet(Model model) {
        var loginDto = new LoginDto();
        loginDto.setPassword("hello");
        loginDto.setUsername("hello");
        model.addAttribute("isSuccessful", true);
        model.addAttribute("loginDto", loginDto);
        return "index";
    }

    @PostMapping("/register")
    public String registerUserPost(@Valid @ModelAttribute("loginDto") LoginDto loginDto, Model model) {
        var response = userService.register(loginDto);
        if(response.isSuccessful())
        {
            return "redirect:/users/mainpage";
        }else {
            model.addAttribute("error", response.getError());
            model.addAttribute("isSuccessful", response.isSuccessful());
            return "index";
        }
    }

    @GetMapping("/mainpage")
    public String registerUserPost(Model model) {
       return "home";
    }
}
