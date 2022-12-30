package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.Reward;
import com.phoyos.apigamification.domain.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RewardPageController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/admin/rewards")
    public String reward(Model model){
        model.addAttribute("rewards", rewardService.getAll());
        return "rewards";
    }

    @GetMapping("/admin/rewards/create")
    public String createReward(Model model){
        model.addAttribute("reward", new Reward());
        return "save-reward";
    }

    @GetMapping("/admin/rewards/edit/{id}")
    public String editCourse(@PathVariable("id") String id, Model model){
        model.addAttribute("reward", rewardService.getById(id));
        return "save-reward";
    }

    @PostMapping("/admin/rewards/save")
    public String saveReward(@Validated @ModelAttribute Reward reward, Model model){
        rewardService.save(reward);
        return "redirect:/admin/rewards";
    }

    @GetMapping("/admin/rewards/delete/{id}")
    public String deleteReward(@PathVariable("id") String id){
        rewardService.deleteById(id);
        return "redirect:/admin/rewards";
    }
}
