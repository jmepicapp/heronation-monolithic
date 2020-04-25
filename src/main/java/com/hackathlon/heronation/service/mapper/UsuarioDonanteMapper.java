package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.UsuarioDonanteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UsuarioDonante} and its DTO {@link UsuarioDonanteDTO}.
 */
@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UsuarioDonanteMapper extends EntityMapper<UsuarioDonanteDTO, UsuarioDonante> {

    @Mapping(source = "rolUsuarioDonante.id", target = "rolUsuarioDonanteId")
    UsuarioDonanteDTO toDto(UsuarioDonante usuarioDonante);

    @Mapping(target = "peticionUsuarioDonantes", ignore = true)
    @Mapping(target = "removePeticionUsuarioDonante", ignore = true)
    @Mapping(source = "rolUsuarioDonanteId", target = "rolUsuarioDonante")
    UsuarioDonante toEntity(UsuarioDonanteDTO usuarioDonanteDTO);

    default UsuarioDonante fromId(Long id) {
        if (id == null) {
            return null;
        }
        UsuarioDonante usuarioDonante = new UsuarioDonante();
        usuarioDonante.setId(id);
        return usuarioDonante;
    }
}
