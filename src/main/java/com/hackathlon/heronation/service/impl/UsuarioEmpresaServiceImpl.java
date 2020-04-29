package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.model.*;
import com.hackathlon.heronation.model.dto.*;
import com.hackathlon.heronation.repository.*;
import com.hackathlon.heronation.service.UsuarioEmpresaService;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link UsuarioEmpresa}.
 */
@Service
@Transactional
public class UsuarioEmpresaServiceImpl implements UsuarioEmpresaService {

    private final Logger log = LoggerFactory.getLogger(UsuarioEmpresaServiceImpl.class);

    @Autowired
    private final UsuarioEmpresaRepository usuarioEmpresaRepository;

    @Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public UsuarioEmpresaServiceImpl(UsuarioEmpresaRepository usuarioEmpresaRepository) {
        this.usuarioEmpresaRepository = usuarioEmpresaRepository;
    }

    /**
     * Save a usuarioEmpresa.
     *
     * @param usuarioEmpresaFrontDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UsuarioEmpresaDTO save(UsuarioEmpresaFrontDTO usuarioEmpresaFrontDTO) {
        log.debug("Request to save UsuarioEmpresa : {}", usuarioEmpresaFrontDTO);

        UsuarioEmpresa usuarioEmpresa = crearUsuarioEmpresa(usuarioEmpresaFrontDTO);
        usuarioEmpresa.setUsuario(crearUsuario(usuarioEmpresaFrontDTO));

        usuarioEmpresa = usuarioEmpresaRepository.save(usuarioEmpresa);
        return ModelMapperUtils.map(usuarioEmpresa, UsuarioEmpresaDTO.class);
    }

    private UsuarioEmpresa crearUsuarioEmpresa(UsuarioEmpresaFrontDTO usuarioEmpresaFrontDTO) {
        UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
        usuarioEmpresa.setId(usuarioEmpresaFrontDTO.getId());
        usuarioEmpresa.setDireccion(ModelMapperUtils.map(usuarioEmpresaFrontDTO.getDireccion(), Direccion.class));
        usuarioEmpresa.setNombre(usuarioEmpresaFrontDTO.getNombre());
        usuarioEmpresa.setTelefono(usuarioEmpresaFrontDTO.getTelefono());
        usuarioEmpresa.setUsuario(crearUsuario(usuarioEmpresaFrontDTO));
        return usuarioEmpresa;
    }

    private Usuario crearUsuario(UsuarioEmpresaFrontDTO usuarioEmpresaFrontDTO) {
        //Creación entidad usuario
        Usuario usuario = new Usuario();
        usuario.setActivo(true);
        usuario.setEmail(usuarioEmpresaFrontDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioEmpresaFrontDTO.getPassword()));
        usuario.setRol(new Rol(Long.valueOf(2), "ROLE_EMPRESA"));
        return usuario;
    }

    /**
     * Get all the usuarioEmpresas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioEmpresaDTO> findAll() {
        log.debug("Request to get all UsuarioEmpresas");
        return ModelMapperUtils.mapAll(usuarioEmpresaRepository.findAll(), UsuarioEmpresaDTO.class);

    }

    /**
     * Get one usuarioEmpresa by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioEmpresaDTO> findOne(Long id) {
        log.debug("Request to get UsuarioEmpresa : {}", id);
        return Optional.of(ModelMapperUtils.map(usuarioEmpresaRepository.findById(id).get(), UsuarioEmpresaDTO.class));

    }

    /**
     * Get one usuarioEmpresa by id.
     *
     * @param email the email of the entity Usuario.
     * @return the entity.
     */
    @Override
    public Optional<UsuarioEmpresaDTO> findByEmailUsuario(String email) {
        return Optional.of(ModelMapperUtils.map(usuarioEmpresaRepository.findByEmailUsuario(email).get(), UsuarioEmpresaDTO.class));
    }

    /**
     * Delete the usuarioEmpresa by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UsuarioEmpresa : {}", id);
        usuarioEmpresaRepository.deleteById(id);
    }
}
