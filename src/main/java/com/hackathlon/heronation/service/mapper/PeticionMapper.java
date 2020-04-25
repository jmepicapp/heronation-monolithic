package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.PeticionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Peticion} and its DTO {@link PeticionDTO}.
 */
@Mapper(componentModel = "spring", uses = {UsuarioDonanteMapper.class, UsuarioEmpresaMapper.class})
public interface PeticionMapper extends EntityMapper<PeticionDTO, Peticion> {

    @Mapping(source = "usuarioDonante.id", target = "usuarioDonanteId")
    @Mapping(source = "usuarioEmpresa.id", target = "usuarioEmpresaId")
    PeticionDTO toDto(Peticion peticion);

    @Mapping(source = "usuarioDonanteId", target = "usuarioDonante")
    @Mapping(source = "usuarioEmpresaId", target = "usuarioEmpresa")
    Peticion toEntity(PeticionDTO peticionDTO);

    default Peticion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Peticion peticion = new Peticion();
        peticion.setId(id);
        return peticion;
    }
}
