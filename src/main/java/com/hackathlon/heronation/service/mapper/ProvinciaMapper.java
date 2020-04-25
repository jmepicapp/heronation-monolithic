package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.ProvinciaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Provincia} and its DTO {@link ProvinciaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProvinciaMapper extends EntityMapper<ProvinciaDTO, Provincia> {



    default Provincia fromId(Long id) {
        if (id == null) {
            return null;
        }
        Provincia provincia = new Provincia();
        provincia.setId(id);
        return provincia;
    }
}
