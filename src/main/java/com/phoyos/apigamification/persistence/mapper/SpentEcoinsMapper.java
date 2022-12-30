package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.SpendEcoins;
import com.phoyos.apigamification.persistence.entity.EcoinsGastado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface SpentEcoinsMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "usuarioId", target = "userId"),
            @Mapping(source = "premioId", target = "rewardId")
    })
    SpendEcoins toSpentEcoins(EcoinsGastado ecoinsGastado);
    List<SpendEcoins> spentEcoinsList(List<EcoinsGastado> ecoinsGastadoList);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "usuario", ignore = true),
            @Mapping(target = "premio", ignore = true)
    })
    EcoinsGastado ecoinsGastado(SpendEcoins spentEcoins);
}
