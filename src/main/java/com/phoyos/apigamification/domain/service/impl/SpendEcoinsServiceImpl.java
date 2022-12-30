package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.SpendEcoins;
import com.phoyos.apigamification.domain.service.SpendEcoinsService;
import com.phoyos.apigamification.persistence.projections.HistoryRedeemed;
import com.phoyos.apigamification.persistence.repository.EcoinsGastadoRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendEcoinsServiceImpl extends GenericServiceImpl<SpendEcoins, String> implements SpendEcoinsService {

    @Autowired
    private EcoinsGastadoRepository ecoinsGastadoRepository;

    @Override
    public GenericRepository<SpendEcoins, String> getRepository() {
        return ecoinsGastadoRepository;
    }

    @Override
    public SpendEcoins save(SpendEcoins spendEcoins) {
        return ecoinsGastadoRepository.save(spendEcoins);
    }

    @Override
    public List<HistoryRedeemed> seeHistory(String userId) {
        return ecoinsGastadoRepository.getHistoryRedeemed(userId);
    }

    @Override
    public SpendEcoins findByUserId(String id) {
        return ecoinsGastadoRepository.getByUserId(id).get();
    }
}
