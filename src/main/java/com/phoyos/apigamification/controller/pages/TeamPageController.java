package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.domain.service.CourseService;
import com.phoyos.apigamification.domain.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamPageController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/admin/teams")
    public String contextTeam(Model model){
        model.addAttribute("teams", teamService.getAll());
        return "teams";
    }

    @GetMapping("/admin/teams/create")
    public String createTeams(Model model){
        model.addAttribute("team", new Team());
        model.addAttribute("courses", courseService.getAll());
        return "save-team";
    }

    @GetMapping("/admin/teams/edit/{id}")
    public String editTeam(@PathVariable("id") String id, Model model){
        model.addAttribute("team", teamService.getById(id));
        model.addAttribute("courses", courseService.getAll());
        return "save-team";
    }

    @PostMapping("/admin/teams/save")
    public String saveTeam(@Validated @ModelAttribute Team team, Model model){
        teamService.save(team);
        return "redirect:/admin/teams";
    }

    @GetMapping("/admin/teams/delete/{id}")
    public String deleteTeam(@PathVariable("id") String id){
        teamService.deleteById(id);
        return "redirect:/admin/teams";
    }
}
