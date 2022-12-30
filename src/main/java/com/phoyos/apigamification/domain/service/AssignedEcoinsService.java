package com.phoyos.apigamification.domain.service;

import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.utils.GenericServiceAPI;

public interface AssignedEcoinsService extends GenericServiceAPI<AssignedEcoins, String> {

    AssignedEcoins save(AssignedEcoins assignedEcoins);

    AssignedEcoins findByUserId(String id);

    void assingEcoins(long value, String id);

    void subtractEcoins(long value, String id);
}
