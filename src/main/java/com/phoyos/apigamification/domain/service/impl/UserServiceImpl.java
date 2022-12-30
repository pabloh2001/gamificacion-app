package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.persistence.projections.DashboardDTOu;
import com.phoyos.apigamification.domain.service.UserService;
import com.phoyos.apigamification.persistence.projections.HomeUsersDTO;
import com.phoyos.apigamification.persistence.repository.UsuarioRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public GenericRepository<User, String> getRepository() {
        return usuarioRepository;
    }

    @Override
    public User findByEmail(String email) {
        return usuarioRepository.findByEmail(email).get();
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usuarioRepository.save(user);
    }

    @Override
    public void edit(User user) {
        usuarioRepository.edit(user);
    }

    @Override
    public List<DashboardDTOu> studentsR() {
        return usuarioRepository.studentsRanking();
    }

    @Override
    public List<HomeUsersDTO> studentsTeam(String id) {
        return usuarioRepository.studentsTeam(id);
    }
}
