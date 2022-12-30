package com.phoyos.apigamification.domain.service;

import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.persistence.projections.DashboardDTOu;
import com.phoyos.apigamification.persistence.projections.HomeUsersDTO;
import com.phoyos.apigamification.utils.GenericServiceAPI;

import java.util.List;

public interface UserService extends GenericServiceAPI<User, String> {
    User findByEmail(String email);
    User save(User user);

    void edit(User user);

    List<DashboardDTOu> studentsR();

    List<HomeUsersDTO> studentsTeam(String id);
}
