package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Role;
import com.phoyos.apigamification.domain.service.RoleService;
import com.phoyos.apigamification.persistence.repository.RolRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, String> implements RoleService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public GenericRepository<Role, String> getRepository() {
        return rolRepository;
    }
}
