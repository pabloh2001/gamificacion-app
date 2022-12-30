package com.phoyos.apigamification.controller.rest;

import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.domain.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/v1/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public ResponseEntity<List<Team>> teams(){
        return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Team> team(@PathVariable("id") String id){
        return teamService.getById(id)
                .map(team -> new ResponseEntity<>(team, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

