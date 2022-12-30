package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Role;
import com.phoyos.apigamification.persistence.dao.RolCrudRepo;
import com.phoyos.apigamification.persistence.entity.Rol;
import com.phoyos.apigamification.persistence.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolRepository implements GenericRepository<Role, String> {

    @Autowired
    private RolCrudRepo rolCrudRepo;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAll() {
        List<Rol> roles = (List<Rol>) rolCrudRepo.findAll();
        return roleMapper.toRoles(roles);
    }

    @Override
    public Optional<Role> get(String s) {
        return rolCrudRepo.findById(s).map(rol -> roleMapper.toRole(rol));
    }

    @Override
    public Role save(Role entity) {
        Rol rol = roleMapper.toRol(entity);
        return roleMapper.toRole(rolCrudRepo.save(rol));
    }

    @Override
    public void delete(String s) {
        rolCrudRepo.deleteById(s);
    }
}
