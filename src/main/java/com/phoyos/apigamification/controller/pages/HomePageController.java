package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.domain.dto.Reward;
import com.phoyos.apigamification.domain.dto.SpendEcoins;
import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.domain.service.AssignedEcoinsService;
import com.phoyos.apigamification.domain.service.RewardService;
import com.phoyos.apigamification.domain.service.SpendEcoinsService;
import com.phoyos.apigamification.domain.service.UserService;
import com.phoyos.apigamification.persistence.projections.HomeUsersDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HomePageController {

    private static String teamId = "";

    @Autowired
    private UserService userService;

    @Autowired
    private RewardService rewardService;

    @Autowired
    private AssignedEcoinsService assignedEcoinsService;
    @Autowired
    private SpendEcoinsService spendEcoinsService;

    @GetMapping("/home")
    public String home(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        long totalEcoins = assignedEcoinsService.findByUserId(user.getId()).getTotal();
        teamId = user.getTeamId();

        int countSpendEcoins = spendEcoinsService.getAll()
                .stream().filter(spendEcoins -> spendEcoins.getUserId().equals(user.getId()))
                .collect(Collectors.toList()).size();

        model.addAttribute("totalEcoins", totalEcoins);
        model.addAttribute("rewards", rewardService.getAll());
        model.addAttribute("countSpendEcoins", String.valueOf(countSpendEcoins));
        return "home";
    }

    @GetMapping("/api/v1/students-team")
    public ResponseEntity<List<HomeUsersDTO>> studentsTeam(){
        return new ResponseEntity<>(userService.studentsTeam(teamId), HttpStatus.OK);
    }

    @PostMapping("/home/redeem-ecoins")
    public String redeem(SpendEcoins spendEcoins){
        Reward reward = rewardService.getById(spendEcoins.getRewardId()).get();
        AssignedEcoins assignedEcoins = assignedEcoinsService.findByUserId(spendEcoins.getUserId());
        if (assignedEcoins.getTotal() >= reward.getValue()){
            assignedEcoinsService.subtractEcoins(reward.getValue(), spendEcoins.getUserId());
            spendEcoinsService.save(spendEcoins);
        } else {
            return "redirect:/home?error=true";
        }
        return "redirect:/home";
    }
}
