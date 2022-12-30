package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.domain.dto.UserResponseDTO;
import com.phoyos.apigamification.domain.service.AssignedEcoinsService;
import com.phoyos.apigamification.domain.service.SpendEcoinsService;
import com.phoyos.apigamification.domain.service.TeamService;
import com.phoyos.apigamification.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class UserPageController {
    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private AssignedEcoinsService assignedEcoinsService;

    @Autowired
    private SpendEcoinsService spendEcoinsService;

    @GetMapping("/admin/users")
    public String contextUsers(Model model, HttpSession session){
        List<UserResponseDTO> users = userService.getAll()
                .stream()
                .filter(user -> user.getRole().getName().equals("ROLE_USER"))
                .map(user -> {
                    if (user.getTeam() != null){
                        Team team = teamService.getById(user.getTeamId()).get();
                        return new UserResponseDTO(user.getId(),user.getName(),user.getLastName(),user.getEmail(),team.getName());
                    }
                    return new UserResponseDTO(user.getId(),user.getName(),user.getLastName(),user.getEmail(),null);
                }).collect(Collectors.toList());

        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/admin/users/create")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("teams", teamService.getAll());
        return "save-user";
    }

    @GetMapping("/admin/users/edit/{id}")
    public String loadUser(@PathVariable("id") String id, Model model){
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("teams", teamService.getAll());
        return "save-user";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") String id){
        //assignedEcoinsService.deleteById(assignedEcoinsService.findByUserId(id).getId());
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/users/save")
    public String saveUser(@Validated @ModelAttribute User user, Model model){
        if (!user.getPassword().isEmpty()){
            userService.save(user);
        } else {
            userService.edit(user);
        }
        List<String> currentsId = assignedEcoinsService.getAll()
                .stream().map(assignedEcoins -> assignedEcoins.getUserId()).collect(Collectors.toList());

        if (!currentsId.contains(user.getId())){
            AssignedEcoins assignedEcoins = new AssignedEcoins();
            assignedEcoins.setUserId(user.getId());
            assignedEcoinsService.save(assignedEcoins);
        }
        return "redirect:/admin/users";
    }
}
