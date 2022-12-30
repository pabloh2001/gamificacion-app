package com.phoyos.apigamification.controller.rest;

import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.domain.dto.UserResponseDTO;
import com.phoyos.apigamification.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDTO>> users(){
        List<UserResponseDTO> response = userService.getAll().stream().map(user -> {
            if (user.getTeam() != null){
                return new UserResponseDTO(user.getId(),user.getName(),user.getLastName(),user.getEmail(),user.getTeam().getName());
            }
            return new UserResponseDTO(user.getId(),user.getName(),user.getLastName(),user.getEmail(),null);
        }).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<UserResponseDTO> user(@PathVariable("id") String id){
        return userService.getById(id)
                .map(user -> new ResponseEntity<>(new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getLastName(),
                        user.getEmail(),
                        (user.getTeam() != null) ? user.getTeam().getName() : null
                ), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
