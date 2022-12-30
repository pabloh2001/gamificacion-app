package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.service.TeamService;
import com.phoyos.apigamification.domain.service.UserService;
import com.phoyos.apigamification.persistence.projections.DashboardDTOt;
import com.phoyos.apigamification.persistence.projections.DashboardDTOu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model){
        model.addAttribute("studentsR", userService.studentsR());
        return "dashboard";
    }

    @GetMapping("/api/v1/ranking-students")
    public ResponseEntity<List<DashboardDTOu>> studentsR(){
        return new ResponseEntity<>(userService.studentsR(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/ranking-teams")
    public ResponseEntity<List<DashboardDTOt>> teamsR(){
        return new ResponseEntity<>(teamService.teamsR(), HttpStatus.OK);
    }
}
