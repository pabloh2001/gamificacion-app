package com.phoyos.apigamification.domain.service.impl;
import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(false);
            builder.password(user.getPassword());
            builder.authorities(user.getRole().getName());
        } else {
            throw new UsernameNotFoundException("Usuario o pasword incorrecto");
        }
        return builder.build();
    }
}
