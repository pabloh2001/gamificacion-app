package com.phoyos.apigamification.controller.rest;
import com.phoyos.apigamification.domain.dto.Reward;
import com.phoyos.apigamification.domain.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/")
    public ResponseEntity<List<Reward>> rewards(){
        return new ResponseEntity<>(rewardService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Reward> reward(@PathVariable("id") String id){
        return rewardService.getById(id)
                .map(reward -> new ResponseEntity<>(reward, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
