package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.model.Direccion;
import com.hackathlon.heronation.model.Rol;
import com.hackathlon.heronation.model.Usuario;
import com.hackathlon.heronation.model.dto.DireccionDTO;
import com.hackathlon.heronation.model.dto.UsuarioDonanteFrontDTO;
import com.hackathlon.heronation.repository.DireccionRepository;
import com.hackathlon.heronation.repository.UsuarioRepository;
import com.hackathlon.heronation.service.UsuarioDonanteService;
import com.hackathlon.heronation.model.UsuarioDonante;
import com.hackathlon.heronation.repository.UsuarioDonanteRepository;
import com.hackathlon.heronation.model.dto.UsuarioDonanteDTO;
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
 * Service Implementation for managing {@link UsuarioDonante}.
 */
@Service
@Transactional
public class UsuarioDonanteServiceImpl implements UsuarioDonanteService {

    private final Logger log = LoggerFactory.getLogger(UsuarioDonanteServiceImpl.class);

    @Autowired
    private final UsuarioDonanteRepository usuarioDonanteRepository;

    @Autowired
    private final DireccionRepository direccionRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public UsuarioDonanteServiceImpl(UsuarioDonanteRepository usuarioDonanteRepository, DireccionRepository direccionRepository, UsuarioRepository usuarioRepository) {
        this.usuarioDonanteRepository = usuarioDonanteRepository;
        this.direccionRepository = direccionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Save a usuarioDonante.
     *
     * @param usuarioDonanteFrontDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UsuarioDonanteDTO save(UsuarioDonanteFrontDTO usuarioDonanteFrontDTO) {
        log.debug("Request to save UsuarioDonante : {}", usuarioDonanteFrontDTO);
        Usuario usuario = crearUsuario(usuarioDonanteFrontDTO);

        UsuarioDonante usuarioDonante = crearUsuarioDonante(usuarioDonanteFrontDTO);

        usuarioDonante = usuarioDonanteRepository.save(usuarioDonante);
        return ModelMapperUtils.map(usuarioDonante, UsuarioDonanteDTO.class);
    }

    private UsuarioDonante crearUsuarioDonante(UsuarioDonanteFrontDTO usuarioDonanteFrontDTO) {
        UsuarioDonante usuarioDonante = new UsuarioDonante();
        usuarioDonante.setApellidos(usuarioDonanteFrontDTO.getApellidos());
        usuarioDonante.setDireccion(ModelMapperUtils.map(usuarioDonanteFrontDTO.getDireccion(), Direccion.class));
        usuarioDonante.setNombre(usuarioDonanteFrontDTO.getNombre());
        usuarioDonante.setTelefono(usuarioDonanteFrontDTO.getTelefono());
        usuarioDonante.setUsuario(crearUsuario(usuarioDonanteFrontDTO));
        return usuarioDonante;
    }

    private Usuario crearUsuario(UsuarioDonanteFrontDTO usuarioDonanteFrontDTO) {
        //Creeación entidad usuario
        Usuario usuario = new Usuario();
        usuario.setActivo(true);
        usuario.setEmail(usuarioDonanteFrontDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioDonanteFrontDTO.getPassword()));
        usuario.setRol(new Rol(Long.valueOf(1), "ROLE_DONANTE"));
        return usuario;
    }

    /**
     * Get all the usuarioDonantes.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDonanteDTO> findAll() {
        log.debug("Request to get all UsuarioDonantes");
        return ModelMapperUtils.mapAll(usuarioDonanteRepository.findAll(), UsuarioDonanteDTO.class);

    }

    /**
     * Get one usuarioDonante by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDonanteDTO> findOne(Long id) {
        log.debug("Request to get UsuarioDonante : {}", id);
        return Optional.of(ModelMapperUtils.map(usuarioDonanteRepository.findById(id).get(), UsuarioDonanteDTO.class));

    }

    /**
     * Get one usuarioDonante by id.
     *
     * @param email the email of the entity Usuario.
     * @return the entity.
     */
    @Override
    public Optional<UsuarioDonanteDTO> findByEmailUsuario(String email) {
        return Optional.of(ModelMapperUtils.map(usuarioDonanteRepository.findByEmailUsuario(email).get(), UsuarioDonanteDTO.class));
    }

    /**
     * Delete the usuarioDonante by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UsuarioDonante : {}", id);
        usuarioDonanteRepository.deleteById(id);
    }
}
