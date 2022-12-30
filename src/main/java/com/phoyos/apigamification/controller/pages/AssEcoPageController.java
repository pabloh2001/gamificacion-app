package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.AEResponseDTO;
import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.domain.service.AssignedEcoinsService;
import com.phoyos.apigamification.domain.service.CategoryService;
import com.phoyos.apigamification.domain.service.TeamService;
import com.phoyos.apigamification.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class AssEcoPageController {

    @Autowired
    private AssignedEcoinsService assignedEcoinsService;

    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/assigned-ecoins")
    public String ecoinsContext(Model model){
        List<AEResponseDTO> aeResponseDTOS = assignedEcoinsService.getAll()
                        .stream()
                        .map(assignedEcoins -> {
                            User user = userService.getById(assignedEcoins.getUserId()).get();
                            Team team = teamService.getById(user.getTeamId()).get();
                            String name = user.getName() + " " +  user.getLastName();
                            return new AEResponseDTO(assignedEcoins.getId(), assignedEcoins.getUserId(), name, team.getName(), assignedEcoins.getTotal());
                        }).collect(Collectors.toList());

        model.addAttribute("ecoins", aeResponseDTOS);
        model.addAttribute("categories", categoryService.getAll());
        return "assigned-ecoins";
    }

    @GetMapping("/admin/assigned-ecoins/to-assign/{id}")
    @ResponseBody
    public ResponseEntity<AssignedEcoins> createAEcoins(@PathVariable("id") String id){
        return new ResponseEntity<>(assignedEcoinsService.getById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/admin/assigned-ecoins/assign")
    public String assingAssEcoins(AssignedEcoins assignedEcoins){
        assignedEcoinsService.assingEcoins(assignedEcoins.getTotal(), assignedEcoins.getId());
        return "redirect:/admin/assigned-ecoins";
    }

    @PostMapping("/admin/assigned-ecoins/save")
    public String saveAssEcoins(AssignedEcoins assignedEcoins){
        assignedEcoinsService.save(assignedEcoins);
        return "redirect:/admin/assigned-ecoins";
    }
}
