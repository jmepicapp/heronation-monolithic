package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.repository.PreferenciaRepository;
import com.hackathlon.heronation.service.UsuarioEmpresaService;
import com.hackathlon.heronation.model.UsuarioEmpresa;
import com.hackathlon.heronation.repository.UsuarioEmpresaRepository;
import com.hackathlon.heronation.model.dto.UsuarioEmpresaDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link UsuarioEmpresa}.
 */
@Service
@Transactional
public class UsuarioEmpresaServiceImpl implements UsuarioEmpresaService {

    private final Logger log = LoggerFactory.getLogger(UsuarioEmpresaServiceImpl.class);

    @Autowired
    private final UsuarioEmpresaRepository usuarioEmpresaRepository;

    public UsuarioEmpresaServiceImpl(UsuarioEmpresaRepository usuarioEmpresaRepository, PreferenciaRepository preferenciaRepository) {
        this.usuarioEmpresaRepository = usuarioEmpresaRepository;
    }

    /**
     * Save a usuarioEmpresa.
     *
     * @param usuarioEmpresaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UsuarioEmpresaDTO save(UsuarioEmpresaDTO usuarioEmpresaDTO) {
        log.debug("Request to save UsuarioEmpresa : {}", usuarioEmpresaDTO);
        UsuarioEmpresa usuarioEmpresa = ModelMapperUtils.map(usuarioEmpresaDTO, UsuarioEmpresa.class);
        usuarioEmpresa = usuarioEmpresaRepository.save(usuarioEmpresa);
        return ModelMapperUtils.map(usuarioEmpresa, UsuarioEmpresaDTO.class);
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
