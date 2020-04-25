package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.UsuarioEmpresaService;
import com.hackathlon.heronation.domain.UsuarioEmpresa;
import com.hackathlon.heronation.repository.UsuarioEmpresaRepository;
import com.hackathlon.heronation.service.dto.UsuarioEmpresaDTO;
import com.hackathlon.heronation.service.mapper.UsuarioEmpresaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UsuarioEmpresa}.
 */
@Service
@Transactional
public class UsuarioEmpresaServiceImpl implements UsuarioEmpresaService {

    private final Logger log = LoggerFactory.getLogger(UsuarioEmpresaServiceImpl.class);

    private final UsuarioEmpresaRepository usuarioEmpresaRepository;

    private final UsuarioEmpresaMapper usuarioEmpresaMapper;

    public UsuarioEmpresaServiceImpl(UsuarioEmpresaRepository usuarioEmpresaRepository, UsuarioEmpresaMapper usuarioEmpresaMapper) {
        this.usuarioEmpresaRepository = usuarioEmpresaRepository;
        this.usuarioEmpresaMapper = usuarioEmpresaMapper;
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
        UsuarioEmpresa usuarioEmpresa = usuarioEmpresaMapper.toEntity(usuarioEmpresaDTO);
        usuarioEmpresa = usuarioEmpresaRepository.save(usuarioEmpresa);
        return usuarioEmpresaMapper.toDto(usuarioEmpresa);
    }

    /**
     * Get all the usuarioEmpresas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UsuarioEmpresaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UsuarioEmpresas");
        return usuarioEmpresaRepository.findAll(pageable)
            .map(usuarioEmpresaMapper::toDto);
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
        return usuarioEmpresaRepository.findById(id)
            .map(usuarioEmpresaMapper::toDto);
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
