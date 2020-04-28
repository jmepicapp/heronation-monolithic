package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.RolDTO;
import com.hackathlon.heronation.model.dto.UsuarioDTO;
import com.hackathlon.heronation.model.dto.UsuarioEmpresaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.Rol}.
 */
public interface UsuarioService {

    /**
     * Get the "id" rol.
     *
     * @param email the id of the entity.
     * @return the entity.
     */
    Optional<UsuarioDTO> findByUsername(String email);

}
