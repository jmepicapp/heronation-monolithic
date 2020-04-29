package com.hackathlon.heronation.service.impl;

import com.hackathlon.heronation.model.dto.UsuarioEmpresaDTO;
import com.hackathlon.heronation.repository.UsuarioEmpresaRepository;
import com.hackathlon.heronation.service.PreferenciaService;
import com.hackathlon.heronation.model.Preferencia;
import com.hackathlon.heronation.repository.PreferenciaRepository;
import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.util.ModelMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Preferencia}.
 */
@Service
@Transactional
public class PreferenciaServiceImpl implements PreferenciaService {

    private final Logger log = LoggerFactory.getLogger(PreferenciaServiceImpl.class);

    @Autowired
    private final PreferenciaRepository preferenciaRepository;

    @Autowired
    private final UsuarioEmpresaRepository usuarioEmpresaRepository;

    public PreferenciaServiceImpl(PreferenciaRepository preferenciaRepository, UsuarioEmpresaRepository usuarioEmpresaRepository) {
        this.preferenciaRepository = preferenciaRepository;
        this.usuarioEmpresaRepository = usuarioEmpresaRepository;
    }

    /**
     * Save a preferencia.
     *
     * @param preferenciaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PreferenciaDTO save(PreferenciaDTO preferenciaDTO) {
        log.debug("Request to save Preferencia : {}", preferenciaDTO);
        Preferencia preferencia = ModelMapperUtils.map(preferenciaDTO, Preferencia.class);
        preferencia = preferenciaRepository.save(preferencia);
        return ModelMapperUtils.map(preferenciaRepository, PreferenciaDTO.class);
    }

    /**
     * Get all the preferencias.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PreferenciaDTO> findAll() {
        log.debug("Request to get all Preferencias");
        return ModelMapperUtils.mapAll(preferenciaRepository.findAll(), PreferenciaDTO.class);

    }

    /**
     * Get all the preferencias by categorias producto id.
     *
     * @param idCategorias the list of categorias producto id
     * @return the list of entities.
     */
    public List<UsuarioEmpresaDTO> findAllByCategoriaProducto(List<Long> idCategorias) {

        List<UsuarioEmpresaDTO> usuarioEmpresaDTOList = ModelMapperUtils.mapAll(usuarioEmpresaRepository.findAll(), UsuarioEmpresaDTO.class);

        for (PreferenciaDTO preferencia : ModelMapperUtils.mapAll(preferenciaRepository.findAll(), PreferenciaDTO.class)) {
            if (idCategorias.contains(preferencia.getCategoriaProducto().getId())) {
                if(usuarioEmpresaDTOList.contains(preferencia.getUsuarioEmpresa())){
                    usuarioEmpresaDTOList.remove(preferencia.getUsuarioEmpresa());
                }
            }
        }

        return usuarioEmpresaDTOList;


//        return this.preferenciaRepository.findAll()
//                .stream()
//                .filter(pr -> idCategorias.contains(pr.getCategoriaProducto().getId()))
//                .filter(usuarioEmpresaDTOList.contains(preferencia.getUsuarioEmpresa())
//                .map(pr ->  ModelMapperUtils.map(pr, PreferenciaDTO.class))
//                .map(pr -> pr.getUsuarioEmpresa())
//                .distinct()
//                .collect(Collectors.toList());

    }

    /**
     * Get all the preferencias by empresa id.
     *
     * @param idEmpresa the list of categorias producto id
     * @return the list of entities.
     */
    public List<PreferenciaDTO> findAllByUsuarioEmpresa(Long idEmpresa) {
        return ModelMapperUtils.mapAll(this.preferenciaRepository.findAllByUsuarioEmpresa(idEmpresa), PreferenciaDTO.class);

    }

    /**
     * Get all the preferencias by empresa id.
     *
     * @param emailUsuarioEmpresa the list of categorias producto id
     * @return the list of entities.
     */
    public List<PreferenciaDTO> findAllByEmailUsuarioEmpresa(String emailUsuarioEmpresa) {
        return ModelMapperUtils.mapAll(this.preferenciaRepository.findAllByEmailUsuarioEmpresa(emailUsuarioEmpresa), PreferenciaDTO.class);

    }

    /**
     * Get one preferencia by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PreferenciaDTO> findOne(Long id) {
        log.debug("Request to get Preferencia : {}", id);
        return Optional.of(ModelMapperUtils.map(preferenciaRepository.findById(id).get(), PreferenciaDTO.class));

    }

    /**
     * Delete the preferencia by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Preferencia : {}", id);
        preferenciaRepository.deleteById(id);
    }
}
