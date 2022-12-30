package com.phoyos.apigamification.domain.service;

import com.phoyos.apigamification.domain.dto.SpendEcoins;
import com.phoyos.apigamification.persistence.projections.HistoryRedeemed;
import com.phoyos.apigamification.utils.GenericServiceAPI;

import java.util.List;

public interface SpendEcoinsService extends GenericServiceAPI<SpendEcoins, String> {

    SpendEcoins save(SpendEcoins spendEcoins);

    List<HistoryRedeemed> seeHistory(String userId);

    SpendEcoins findByUserId(String id);
}
