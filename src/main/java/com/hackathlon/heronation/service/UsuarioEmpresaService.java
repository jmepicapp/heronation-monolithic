package com.hackathlon.heronation.service;

import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.model.dto.UsuarioDonanteDTO;
import com.hackathlon.heronation.model.dto.UsuarioEmpresaDTO;

import com.hackathlon.heronation.model.dto.UsuarioEmpresaFrontDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.hackathlon.heronation.model.UsuarioEmpresa}.
 */
public interface UsuarioEmpresaService {

    /**
     * Save a usuarioEmpresa.
     *
     * @param usuarioEmpresaFrontDTO the entity to save.
     * @return the persisted entity.
     */
    UsuarioEmpresaDTO save(UsuarioEmpresaFrontDTO usuarioEmpresaFrontDTO);

    /**
     * Get all the usuarioEmpresas.
     *
     * @return the list of entities.
     */
    List<UsuarioEmpresaDTO> findAll();

    /**
     * Get the "id" usuarioEmpresa.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UsuarioEmpresaDTO> findOne(Long id);

    /**
     * Get the "id" usuarioEmpresa.
     *
     * @param email the email of the entity usuario.
     * @return the entity.
     */
    Optional<UsuarioEmpresaDTO> findByEmailUsuario(String email);

    /**
     * Delete the "id" usuarioEmpresa.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
