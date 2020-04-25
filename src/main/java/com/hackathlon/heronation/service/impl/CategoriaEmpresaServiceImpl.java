package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.CategoriaEmpresaService;
import com.hackathlon.heronation.model.CategoriaEmpresa;
import com.hackathlon.heronation.repository.CategoriaEmpresaRepository;
import com.hackathlon.heronation.service.dto.CategoriaEmpresaDTO;
import com.hackathlon.heronation.service.mapper.CategoriaEmpresaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link CategoriaEmpresa}.
 */
@Service
@Transactional
public class CategoriaEmpresaServiceImpl implements CategoriaEmpresaService {

    private final Logger log = LoggerFactory.getLogger(CategoriaEmpresaServiceImpl.class);

    private final CategoriaEmpresaRepository categoriaEmpresaRepository;

    private final CategoriaEmpresaMapper categoriaEmpresaMapper;

    public CategoriaEmpresaServiceImpl(CategoriaEmpresaRepository categoriaEmpresaRepository, CategoriaEmpresaMapper categoriaEmpresaMapper) {
        this.categoriaEmpresaRepository = categoriaEmpresaRepository;
        this.categoriaEmpresaMapper = categoriaEmpresaMapper;
    }

    /**
     * Save a categoriaEmpresa.
     *
     * @param categoriaEmpresaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CategoriaEmpresaDTO save(CategoriaEmpresaDTO categoriaEmpresaDTO) {
        log.debug("Request to save CategoriaEmpresa : {}", categoriaEmpresaDTO);
        CategoriaEmpresa categoriaEmpresa = categoriaEmpresaMapper.toEntity(categoriaEmpresaDTO);
        categoriaEmpresa = categoriaEmpresaRepository.save(categoriaEmpresa);
        return categoriaEmpresaMapper.toDto(categoriaEmpresa);
    }

    /**
     * Get all the categoriaEmpresas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoriaEmpresaDTO> findAll() {
        log.debug("Request to get all CategoriaEmpresas");
        return categoriaEmpresaRepository.findAllWithEagerRelationships().stream()
            .map(categoriaEmpresaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get all the categoriaEmpresas with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<CategoriaEmpresaDTO> findAllWithEagerRelationships(Pageable pageable) {
        return categoriaEmpresaRepository.findAllWithEagerRelationships(pageable).map(categoriaEmpresaMapper::toDto);
    }

    /**
     * Get one categoriaEmpresa by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaEmpresaDTO> findOne(Long id) {
        log.debug("Request to get CategoriaEmpresa : {}", id);
        return categoriaEmpresaRepository.findOneWithEagerRelationships(id)
            .map(categoriaEmpresaMapper::toDto);
    }

    /**
     * Delete the categoriaEmpresa by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CategoriaEmpresa : {}", id);
        categoriaEmpresaRepository.deleteById(id);
    }
}
