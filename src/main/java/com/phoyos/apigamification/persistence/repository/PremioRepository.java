package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Reward;
import com.phoyos.apigamification.persistence.dao.PremioCrudRepo;
import com.phoyos.apigamification.persistence.entity.Premio;
import com.phoyos.apigamification.persistence.mapper.RewardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PremioRepository implements GenericRepository<Reward, String> {

    @Autowired
    private PremioCrudRepo premioCrudRepo;

    @Autowired
    private RewardMapper rewardMapper;

    @Override
    public List<Reward> getAll() {
        List<Premio> cursos = (List<Premio>) premioCrudRepo.findAll();
        return rewardMapper.toRewards(cursos);
    }

    @Override
    public Optional<Reward> get(String s) {
        return premioCrudRepo.findById(s).map(premio -> rewardMapper.toReward(premio));
    }

    @Override
    public Reward save(Reward entity) {
        Premio premio = rewardMapper.toPremio(entity);
        return rewardMapper.toReward(premioCrudRepo.save(premio));
    }

    @Override
    public void delete(String s) {
        premioCrudRepo.deleteById(s);
    }
}
