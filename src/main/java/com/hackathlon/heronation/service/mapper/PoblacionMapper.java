package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.PoblacionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Poblacion} and its DTO {@link PoblacionDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProvinciaMapper.class})
public interface PoblacionMapper extends EntityMapper<PoblacionDTO, Poblacion> {

    @Mapping(source = "poblacionProvincia.id", target = "poblacionProvinciaId")
    PoblacionDTO toDto(Poblacion poblacion);

    @Mapping(source = "poblacionProvinciaId", target = "poblacionProvincia")
    Poblacion toEntity(PoblacionDTO poblacionDTO);

    default Poblacion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Poblacion poblacion = new Poblacion();
        poblacion.setId(id);
        return poblacion;
    }
}
