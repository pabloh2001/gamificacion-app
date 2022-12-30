package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public String register(@ModelAttribute User user,  Model model){
        //log.info("flag: " + user.toString());
        if (user.getPassword().equals(user.getConfirmPassword())){
            model.addAttribute("user", userService.save(user));
        } else {
            return "redirect:/auth/register?error=true";
        }
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/remember-password")
    public String rememberPassword(){
        return "forgot-password";
    }
}
