package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.dto.Reward;
import com.phoyos.apigamification.domain.service.RewardService;
import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.persistence.repository.PremioRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl extends GenericServiceImpl<Reward,String> implements RewardService {

    @Autowired
    private PremioRepository premioRepository;

    @Override
    public GenericRepository<Reward, String> getRepository() {
        return premioRepository;
    }

    @Override
    public Reward save(Reward reward) {
        return premioRepository.save(reward);
    }
}
