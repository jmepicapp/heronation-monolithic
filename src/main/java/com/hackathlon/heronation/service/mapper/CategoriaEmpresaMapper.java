package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.CategoriaEmpresaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CategoriaEmpresa} and its DTO {@link CategoriaEmpresaDTO}.
 */
@Mapper(componentModel = "spring", uses = {UsuarioEmpresaMapper.class})
public interface CategoriaEmpresaMapper extends EntityMapper<CategoriaEmpresaDTO, CategoriaEmpresa> {


    @Mapping(target = "removeUsuarioEmpresa", ignore = true)

    default CategoriaEmpresa fromId(Long id) {
        if (id == null) {
            return null;
        }
        CategoriaEmpresa categoriaEmpresa = new CategoriaEmpresa();
        categoriaEmpresa.setId(id);
        return categoriaEmpresa;
    }
}
