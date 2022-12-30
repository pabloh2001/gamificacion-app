package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.domain.service.TeamService;
import com.phoyos.apigamification.persistence.projections.DashboardDTOt;
import com.phoyos.apigamification.persistence.repository.EquipoRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl extends GenericServiceImpl<Team, String> implements TeamService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public GenericRepository<Team, String> getRepository() {
        return equipoRepository;
    }

    @Override
    public Team save(Team team) {
        return equipoRepository.save(team);
    }

    @Override
    public List<DashboardDTOt> teamsR() {
        return equipoRepository.teamsRankign();
    }
}
