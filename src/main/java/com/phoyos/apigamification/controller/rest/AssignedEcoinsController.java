package com.phoyos.apigamification.controller.rest;

import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.domain.service.AssignedEcoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/assigned-ecoins")
public class AssignedEcoinsController {

    @Autowired
    private AssignedEcoinsService assignedEcoinsService;

    @GetMapping("/")
    public ResponseEntity<List<AssignedEcoins>> ecoins(){
        return new ResponseEntity<>(assignedEcoinsService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<AssignedEcoins> ecoin(@PathVariable("id") String id){
        return assignedEcoinsService.getById(id)
                .map(assignedEcoins -> new ResponseEntity<>(assignedEcoins, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
