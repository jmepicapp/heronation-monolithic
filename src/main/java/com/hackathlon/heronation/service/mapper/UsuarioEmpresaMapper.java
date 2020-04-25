package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.UsuarioEmpresaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UsuarioEmpresa} and its DTO {@link UsuarioEmpresaDTO}.
 */
@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface UsuarioEmpresaMapper extends EntityMapper<UsuarioEmpresaDTO, UsuarioEmpresa> {

    @Mapping(source = "rolUsuarioEmpresa.id", target = "rolUsuarioEmpresaId")
    UsuarioEmpresaDTO toDto(UsuarioEmpresa usuarioEmpresa);

    @Mapping(target = "preferenciaUsuarioEmpresas", ignore = true)
    @Mapping(target = "removePreferenciaUsuarioEmpresa", ignore = true)
    @Mapping(target = "peticionUsuarioEmpresas", ignore = true)
    @Mapping(target = "removePeticionUsuarioEmpresa", ignore = true)
    @Mapping(source = "rolUsuarioEmpresaId", target = "rolUsuarioEmpresa")
    @Mapping(target = "categoriaEmpresas", ignore = true)
    @Mapping(target = "removeCategoriaEmpresa", ignore = true)
    UsuarioEmpresa toEntity(UsuarioEmpresaDTO usuarioEmpresaDTO);

    default UsuarioEmpresa fromId(Long id) {
        if (id == null) {
            return null;
        }
        UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
        usuarioEmpresa.setId(id);
        return usuarioEmpresa;
    }
}
