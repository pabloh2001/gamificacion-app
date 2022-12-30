package com.phoyos.apigamification.controller.rest;
import com.phoyos.apigamification.domain.dto.SpendEcoins;
import com.phoyos.apigamification.domain.service.SpendEcoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/spent-ecoins")
public class SpentEcoinsController {

    @Autowired
    private SpendEcoinsService spendEcoinsService;

    @GetMapping("/")
    public ResponseEntity<List<SpendEcoins>> spentEcoinsList(){
        return new ResponseEntity<>(spendEcoinsService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<SpendEcoins> spentEcoins(@PathVariable("id") String id){
        return spendEcoinsService.getById(id)
                .map(spentEcoins -> new ResponseEntity<>(spentEcoins, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
