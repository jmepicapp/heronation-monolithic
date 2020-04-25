package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.RolDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Rol} and its DTO {@link RolDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RolMapper extends EntityMapper<RolDTO, Rol> {



    default Rol fromId(Long id) {
        if (id == null) {
            return null;
        }
        Rol rol = new Rol();
        rol.setId(id);
        return rol;
    }
}
