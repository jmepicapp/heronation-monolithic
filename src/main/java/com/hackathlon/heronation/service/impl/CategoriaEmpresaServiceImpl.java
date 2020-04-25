package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.CategoriaEmpresaService;
import com.hackathlon.heronation.model.CategoriaEmpresa;
import com.hackathlon.heronation.repository.CategoriaEmpresaRepository;
import com.hackathlon.heronation.model.dto.CategoriaEmpresaDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CategoriaEmpresa}.
 */
@Service
@Transactional
public class CategoriaEmpresaServiceImpl implements CategoriaEmpresaService {

    private final Logger log = LoggerFactory.getLogger(CategoriaEmpresaServiceImpl.class);

    private final CategoriaEmpresaRepository categoriaEmpresaRepository;

    public CategoriaEmpresaServiceImpl(CategoriaEmpresaRepository categoriaEmpresaRepository) {
        this.categoriaEmpresaRepository = categoriaEmpresaRepository;
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
        CategoriaEmpresa categoriaEmpresa = ModelMapperUtils.map(categoriaEmpresaDTO, CategoriaEmpresa.class);
        categoriaEmpresa = categoriaEmpresaRepository.save(categoriaEmpresa);
        return ModelMapperUtils.map(categoriaEmpresa, CategoriaEmpresaDTO.class);
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
        return ModelMapperUtils.mapAll(categoriaEmpresaRepository.findAllWithEagerRelationships(), CategoriaEmpresaDTO.class);
    }

    @Override
    public List<CategoriaEmpresaDTO> findAllWithEagerRelationships(Pageable pageable) {
        return ModelMapperUtils.mapAll(categoriaEmpresaRepository.findAllWithEagerRelationships(pageable), CategoriaEmpresaDTO.class);
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
        return Optional.of(ModelMapperUtils.map(categoriaEmpresaRepository.findOneWithEagerRelationships(id), CategoriaEmpresaDTO.class));
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
