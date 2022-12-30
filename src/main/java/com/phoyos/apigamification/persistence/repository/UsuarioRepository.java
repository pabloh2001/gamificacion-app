package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.persistence.projections.DashboardDTOu;
import com.phoyos.apigamification.persistence.dao.RolCrudRepo;
import com.phoyos.apigamification.persistence.dao.UsuarioCrudRepo;
import com.phoyos.apigamification.persistence.entity.Usuario;
import com.phoyos.apigamification.persistence.mapper.RoleMapper;
import com.phoyos.apigamification.persistence.mapper.UserMapper;
import com.phoyos.apigamification.persistence.projections.HomeUsersDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class UsuarioRepository implements GenericRepository<User, String> {

    @Autowired
    private UsuarioCrudRepo usuarioCrudRepo;

    @Autowired
    private RolCrudRepo rolCrudRepo;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<User> getAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepo.findAll();
        return userMapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> get(String s) {
        return usuarioCrudRepo.findById(s).map(usuario -> userMapper.toUser(usuario));
    }

    @Override
    public User save(User entity) {
        Usuario usuario = userMapper.toUsuario(entity);
        return userMapper.toUser(usuarioCrudRepo.save(usuario));
    }

    @Override
    public void delete(String s) {
        usuarioCrudRepo.deleteById(s);
    }

    public void edit(User user){
        usuarioCrudRepo.edit(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getTeamId());
    }

    public Optional<User> findByEmail(String email){
        return usuarioCrudRepo.findByEmail(email).map(usuario -> userMapper.toUser(usuario));
    }

    public List<DashboardDTOu> studentsRanking(){
        return usuarioCrudRepo.studensRaking();
    }

    public List<HomeUsersDTO> studentsTeam(String id){
        return usuarioCrudRepo.studentsTeam(id);
    }
}
