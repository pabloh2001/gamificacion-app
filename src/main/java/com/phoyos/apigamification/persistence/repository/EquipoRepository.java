package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.persistence.dao.EquipoCrudRepo;
import com.phoyos.apigamification.persistence.entity.Equipo;
import com.phoyos.apigamification.persistence.mapper.TeamMapper;
import com.phoyos.apigamification.persistence.projections.DashboardDTOt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EquipoRepository implements GenericRepository<Team, String> {

    @Autowired
    private EquipoCrudRepo equipoCrudRepo;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Team> getAll() {
        List<Equipo> equipos = (List<Equipo>) equipoCrudRepo.findAll();
        return teamMapper.toTeams(equipos);
    }

    @Override
    public Optional<Team> get(String s) {
        return equipoCrudRepo.findById(s).map(equipo -> teamMapper.toTeam(equipo));
    }

    @Override
    public Team save(Team entity) {
        Equipo equipo = teamMapper.toEquipo(entity);
        return teamMapper.toTeam(equipoCrudRepo.save(equipo));
    }

    @Override
    public void delete(String s) {
        equipoCrudRepo.deleteById(s);
    }

    public List<DashboardDTOt> teamsRankign(){
        return equipoCrudRepo.teamsRanking();
    }
}
