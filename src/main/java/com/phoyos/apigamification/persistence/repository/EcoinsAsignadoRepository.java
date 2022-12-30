package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.persistence.dao.CategoriaCrudRepo;
import com.phoyos.apigamification.persistence.dao.EcoinsAsignadoCrudRepo;
import com.phoyos.apigamification.persistence.entity.EcoinsAsignado;
import com.phoyos.apigamification.persistence.mapper.AssignedEcoinsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EcoinsAsignadoRepository implements GenericRepository<AssignedEcoins, String> {

    @Autowired
    private EcoinsAsignadoCrudRepo ecoinsAsignadoCrudRepo;

    @Autowired
    private CategoriaCrudRepo categoriaCrudRepo;

    @Autowired
    private AssignedEcoinsMapper assignedEcoinsMapper;


    @Override
    public List<AssignedEcoins> getAll() {
        List<EcoinsAsignado> ecoinsAsignados = (List<EcoinsAsignado>) ecoinsAsignadoCrudRepo.findAll();
        return assignedEcoinsMapper.toAssignedEcoinsList(ecoinsAsignados);
    }

    @Override
    public Optional<AssignedEcoins> get(String s) {
        return ecoinsAsignadoCrudRepo.findById(s).map(ecoinsAsignado -> assignedEcoinsMapper.toAssignedEcoins(ecoinsAsignado));
    }

    public Optional<AssignedEcoins> getByUserId(String id){
        return ecoinsAsignadoCrudRepo.getByUsuario(id).map(ecoinsAsignado -> assignedEcoinsMapper.toAssignedEcoins(ecoinsAsignado));
    }

    public void assignEcoins(Long value, String id){
        ecoinsAsignadoCrudRepo.assignEcoin(value, id);
    }

    public void subtractEcoins(Long value, String id){
        ecoinsAsignadoCrudRepo.subtractEcoin(value, id);
    }

    @Override
    public AssignedEcoins save(AssignedEcoins entity) {
        EcoinsAsignado ecoinsAsignado = assignedEcoinsMapper.toEcoinsAsignado(entity);

        return assignedEcoinsMapper.toAssignedEcoins(ecoinsAsignadoCrudRepo.save(ecoinsAsignado));
    }

    @Override
    public void delete(String s) {
        ecoinsAsignadoCrudRepo.deleteById(s);
    }

}
