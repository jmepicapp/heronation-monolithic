package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.service.CategoriaProductoService;
import com.hackathlon.heronation.domain.CategoriaProducto;
import com.hackathlon.heronation.repository.CategoriaProductoRepository;
import com.hackathlon.heronation.service.dto.CategoriaProductoDTO;
import com.hackathlon.heronation.service.mapper.CategoriaProductoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link CategoriaProducto}.
 */
@Service
@Transactional
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    private final Logger log = LoggerFactory.getLogger(CategoriaProductoServiceImpl.class);

    private final CategoriaProductoRepository categoriaProductoRepository;

    private final CategoriaProductoMapper categoriaProductoMapper;

    public CategoriaProductoServiceImpl(CategoriaProductoRepository categoriaProductoRepository, CategoriaProductoMapper categoriaProductoMapper) {
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.categoriaProductoMapper = categoriaProductoMapper;
    }

    /**
     * Save a categoriaProducto.
     *
     * @param categoriaProductoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CategoriaProductoDTO save(CategoriaProductoDTO categoriaProductoDTO) {
        log.debug("Request to save CategoriaProducto : {}", categoriaProductoDTO);
        CategoriaProducto categoriaProducto = categoriaProductoMapper.toEntity(categoriaProductoDTO);
        categoriaProducto = categoriaProductoRepository.save(categoriaProducto);
        return categoriaProductoMapper.toDto(categoriaProducto);
    }

    /**
     * Get all the categoriaProductos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoriaProductoDTO> findAll() {
        log.debug("Request to get all CategoriaProductos");
        return categoriaProductoRepository.findAll().stream()
            .map(categoriaProductoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one categoriaProducto by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaProductoDTO> findOne(Long id) {
        log.debug("Request to get CategoriaProducto : {}", id);
        return categoriaProductoRepository.findById(id)
            .map(categoriaProductoMapper::toDto);
    }

    /**
     * Delete the categoriaProducto by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CategoriaProducto : {}", id);
        categoriaProductoRepository.deleteById(id);
    }
}
