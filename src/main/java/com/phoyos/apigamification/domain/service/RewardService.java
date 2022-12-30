package com.phoyos.apigamification.domain.service;

import com.phoyos.apigamification.domain.dto.Reward;
import com.phoyos.apigamification.utils.GenericServiceAPI;

public interface RewardService extends GenericServiceAPI<Reward, String> {

    Reward save(Reward reward);
}
