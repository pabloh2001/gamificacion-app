package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.domain.service.CourseService;
import com.phoyos.apigamification.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class PagesController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;


    @GetMapping("/")
    public String context(Authentication auth, HttpSession session, Model model){
        String username = auth.getName();
        User user = null;
        if (session.getAttribute("user") == null){
            user = userService.findByEmail(username);
            user.setPassword(null);
            session.setAttribute("user", user);
        }
        if (user.getRole().getName().equals("ROLE_ADMIN")) return "redirect:/admin/dashboard";

        return "redirect:/home";
    }

    @GetMapping("/auth/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/auth/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

}