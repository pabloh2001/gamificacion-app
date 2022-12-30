package com.phoyos.apigamification.domain.service;

import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.persistence.projections.DashboardDTOt;
import com.phoyos.apigamification.utils.GenericServiceAPI;

import java.util.List;

public interface TeamService extends GenericServiceAPI<Team, String> {

    Team save(Team team);

    List<DashboardDTOt> teamsR();
}
