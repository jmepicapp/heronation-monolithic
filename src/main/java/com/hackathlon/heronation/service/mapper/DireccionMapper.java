package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.DireccionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Direccion} and its DTO {@link DireccionDTO}.
 */
@Mapper(componentModel = "spring", uses = {UsuarioEmpresaMapper.class, UsuarioDonanteMapper.class, PoblacionMapper.class})
public interface DireccionMapper extends EntityMapper<DireccionDTO, Direccion> {

    @Mapping(source = "direccionEmpresa.id", target = "direccionEmpresaId")
    @Mapping(source = "direccionDonante.id", target = "direccionDonanteId")
    @Mapping(source = "direccionPoblacion.id", target = "direccionPoblacionId")
    DireccionDTO toDto(Direccion direccion);

    @Mapping(source = "direccionEmpresaId", target = "direccionEmpresa")
    @Mapping(source = "direccionDonanteId", target = "direccionDonante")
    @Mapping(source = "direccionPoblacionId", target = "direccionPoblacion")
    Direccion toEntity(DireccionDTO direccionDTO);

    default Direccion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Direccion direccion = new Direccion();
        direccion.setId(id);
        return direccion;
    }
}
