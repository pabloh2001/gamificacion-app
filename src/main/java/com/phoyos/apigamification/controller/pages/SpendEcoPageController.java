package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.*;
import com.phoyos.apigamification.domain.service.*;
import com.phoyos.apigamification.persistence.projections.HistoryRedeemed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class SpendEcoPageController {

    @Autowired
    private SpendEcoinsService spendEcoinsService;
    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;

    @Autowired
    private AssignedEcoinsService assignedEcoinsService;

    @Autowired
    private RewardService rewardService;

    @GetMapping("/admin/redeem-ecoins")
    public String spentEcoins(Model model){
        List<AEResponseDTO> aeResponseDTOS = assignedEcoinsService.getAll()
                .stream()
                .map(assignedEcoins -> {
                    User user = userService.getById(assignedEcoins.getUserId()).get();
                    Team team = teamService.getById(user.getTeamId()).get();
                    String name = user.getName() + " " +  user.getLastName();
                    return new AEResponseDTO(assignedEcoins.getId(), assignedEcoins.getUserId(), name, team.getName(), assignedEcoins.getTotal());
                }).collect(Collectors.toList());

        model.addAttribute("ecoins", aeResponseDTOS);
        model.addAttribute("rewards", rewardService.getAll());
        return "spend-ecoins";
    }

    @GetMapping("/admin/redeem-ecoins/to-redeem/{id}")
    public ResponseEntity<AssignedEcoins> createSEcoin(@PathVariable("id") String id){
        return new ResponseEntity<>(assignedEcoinsService.getById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/admin/redeem-ecoins/redeemed/{id}")
    public ResponseEntity<List<HistoryRedeemed>> seeHistory(@PathVariable("id") String id){
        return new ResponseEntity<>(spendEcoinsService.seeHistory(id), HttpStatus.OK);
    }

    @PostMapping("/admin/redeem-ecoins/redeem")
    public String saveEspEcoins(SpendEcoins spendEcoins){
        Reward reward = rewardService.getById(spendEcoins.getRewardId()).get();
        AssignedEcoins assignedEcoins = assignedEcoinsService.findByUserId(spendEcoins.getUserId());
        if (assignedEcoins.getTotal() >= reward.getValue()){
            assignedEcoinsService.subtractEcoins(reward.getValue(), spendEcoins.getUserId());
            spendEcoinsService.save(spendEcoins);
        } else {
            return "redirect:/admin/redeem-ecoins?error=true";
        }
        return "redirect:/admin/redeem-ecoins";
    }
}
