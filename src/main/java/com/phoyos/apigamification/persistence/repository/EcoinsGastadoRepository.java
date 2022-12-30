package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.SpendEcoins;
import com.phoyos.apigamification.persistence.dao.EcoinsGastadoCrudRepo;
import com.phoyos.apigamification.persistence.entity.EcoinsGastado;
import com.phoyos.apigamification.persistence.mapper.SpentEcoinsMapper;
import com.phoyos.apigamification.persistence.projections.HistoryRedeemed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EcoinsGastadoRepository implements GenericRepository<SpendEcoins, String> {

    @Autowired
    private EcoinsGastadoCrudRepo ecoinsGastadoCrudRepo;

    @Autowired
    private SpentEcoinsMapper spentEcoinsMapper;

    @Override
    public List<SpendEcoins> getAll() {
        List<EcoinsGastado> ecoinsGastados = (List<EcoinsGastado>) ecoinsGastadoCrudRepo.findAll();
        return spentEcoinsMapper.spentEcoinsList(ecoinsGastados);
    }

    @Override
    public Optional<SpendEcoins> get(String s) {
        return ecoinsGastadoCrudRepo.findById(s).map(ecoinsGastado -> spentEcoinsMapper.toSpentEcoins(ecoinsGastado));
    }

    @Override
    public SpendEcoins save(SpendEcoins entity) {
        EcoinsGastado ecoinsGastado = spentEcoinsMapper.ecoinsGastado(entity);
        return spentEcoinsMapper.toSpentEcoins(ecoinsGastadoCrudRepo.save(ecoinsGastado));
    }

    @Override
    public void delete(String s) {
        ecoinsGastadoCrudRepo.deleteById(s);
    }

    public List<HistoryRedeemed> getHistoryRedeemed(String userId){
        return ecoinsGastadoCrudRepo.seeHistory(userId);
    }

    public Optional<SpendEcoins> getByUserId(String id){
        return ecoinsGastadoCrudRepo.getByUsuario(id).map(ecoinsGastado -> spentEcoinsMapper.toSpentEcoins(ecoinsGastado));
    }
}
