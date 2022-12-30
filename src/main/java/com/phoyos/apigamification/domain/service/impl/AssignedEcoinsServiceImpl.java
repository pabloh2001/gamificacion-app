package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.domain.service.AssignedEcoinsService;
import com.phoyos.apigamification.persistence.repository.EcoinsAsignadoRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignedEcoinsServiceImpl extends GenericServiceImpl<AssignedEcoins, String> implements AssignedEcoinsService {

    @Autowired
    private EcoinsAsignadoRepository ecoinsAsignadoRepository;

    @Override
    public GenericRepository<AssignedEcoins, String> getRepository() {
        return ecoinsAsignadoRepository;
    }

    @Override
    public AssignedEcoins save(AssignedEcoins assignedEcoins) {
        return ecoinsAsignadoRepository.save(assignedEcoins);
    }

    @Override
    public AssignedEcoins findByUserId(String id) {
        return ecoinsAsignadoRepository.getByUserId(id).get();
    }

    @Override
    public void assingEcoins(long value, String id) {
        ecoinsAsignadoRepository.assignEcoins(value, id);
    }

    @Override
    public void subtractEcoins(long value, String id) {
        ecoinsAsignadoRepository.subtractEcoins(value, id);
    }
}
