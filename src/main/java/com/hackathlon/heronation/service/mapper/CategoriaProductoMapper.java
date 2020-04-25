package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.CategoriaProductoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CategoriaProducto} and its DTO {@link CategoriaProductoDTO}.
 */
@Mapper(componentModel = "spring", uses = {PreferenciaMapper.class})
public interface CategoriaProductoMapper extends EntityMapper<CategoriaProductoDTO, CategoriaProducto> {

    @Mapping(source = "preferencia.id", target = "preferenciaId")
    CategoriaProductoDTO toDto(CategoriaProducto categoriaProducto);

    @Mapping(source = "preferenciaId", target = "preferencia")
    CategoriaProducto toEntity(CategoriaProductoDTO categoriaProductoDTO);

    default CategoriaProducto fromId(Long id) {
        if (id == null) {
            return null;
        }
        CategoriaProducto categoriaProducto = new CategoriaProducto();
        categoriaProducto.setId(id);
        return categoriaProducto;
    }
}
