package com.hackathlon.heronation.service.mapper;


import com.hackathlon.heronation.domain.*;
import com.hackathlon.heronation.service.dto.PreferenciaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Preferencia} and its DTO {@link PreferenciaDTO}.
 */
@Mapper(componentModel = "spring", uses = {UsuarioEmpresaMapper.class})
public interface PreferenciaMapper extends EntityMapper<PreferenciaDTO, Preferencia> {

    @Mapping(source = "usuarioEmpresa.id", target = "usuarioEmpresaId")
    PreferenciaDTO toDto(Preferencia preferencia);

    @Mapping(target = "categoriaPreferencias", ignore = true)
    @Mapping(target = "removeCategoriaPreferencia", ignore = true)
    @Mapping(source = "usuarioEmpresaId", target = "usuarioEmpresa")
    Preferencia toEntity(PreferenciaDTO preferenciaDTO);

    default Preferencia fromId(Long id) {
        if (id == null) {
            return null;
        }
        Preferencia preferencia = new Preferencia();
        preferencia.setId(id);
        return preferencia;
    }
}
