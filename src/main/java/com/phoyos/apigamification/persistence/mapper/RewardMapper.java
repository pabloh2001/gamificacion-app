package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.Reward;
import com.phoyos.apigamification.persistence.entity.Premio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RewardMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "valor", target = "value")
    })
    Reward toReward(Premio premio);
    List<Reward> toRewards(List<Premio> premios);

    @InheritInverseConfiguration
    Premio toPremio(Reward reward);
}
