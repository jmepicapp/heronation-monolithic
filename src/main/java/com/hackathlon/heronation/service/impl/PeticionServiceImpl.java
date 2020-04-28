package com.hackathlon.heronation.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathlon.heronation.controller.error.BadRequestAlertException;
import com.hackathlon.heronation.model.Peticion;
import com.hackathlon.heronation.model.dto.PeticionDTO;
import com.hackathlon.heronation.repository.PeticionRepository;
import com.hackathlon.heronation.service.PeticionService;
import com.hackathlon.heronation.util.ModelMapperUtils;
import com.hackathlon.heronation.util.type.EstadoPeticion;

/**
 * Service Implementation for managing {@link Peticion}.
 */
@Service
@Transactional
public class PeticionServiceImpl implements PeticionService {

    private final Logger log = LoggerFactory.getLogger(PeticionServiceImpl.class);

    @Autowired
    private final PeticionRepository peticionRepository;

    public PeticionServiceImpl(PeticionRepository peticionRepository) {
        this.peticionRepository = peticionRepository;
    }

    /**
     * Save a peticion.
     *
     * @param peticionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PeticionDTO save(PeticionDTO peticionDTO) {
        log.debug("Request to save Peticion : {}", peticionDTO);
        if(validarPeticion(peticionDTO)){
            throw new BadRequestAlertException("Peticion","Ya existe una donacion en curso");
        }
        Peticion peticion = ModelMapperUtils.map(peticionDTO, Peticion.class);
        peticion.setEstado(EstadoPeticion.PENDIENTE.name());
        peticion = peticionRepository.save(peticion);
        return ModelMapperUtils.map(peticion, PeticionDTO.class);
    }

    private boolean validarPeticion(PeticionDTO peticionDTO) {
       Long numeroPeticion =  peticionRepository.findAll()
                .stream()
                .filter(peticion -> peticion.getUsuarioDonante().getId().equals(peticionDTO.getUsuarioDonante().getId()))
                .filter(peticion -> peticion.getUsuarioEmpresa().getId().equals(peticionDTO.getUsuarioEmpresa().getId()))
                .filter(peticion -> EstadoPeticion.PENDIENTE.name().equals(peticion.getEstado()))
                .count();
        return numeroPeticion >= 1;
    }

    /**
     * Get all the peticions.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PeticionDTO> findAll() {
        log.debug("Request to get all Peticions");
        return ModelMapperUtils.mapAll(peticionRepository.findAll(), PeticionDTO.class);

    }
    
    /**
     * Get all the peticiones by usuario id.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
    public List<PeticionDTO> findAllByIdUsuario(Long idUsuario){
        return ModelMapperUtils.mapAll(this.peticionRepository.findAllByIdUsuario(idUsuario), PeticionDTO.class);

    }

    /**
     * Get one peticion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PeticionDTO> findOne(Long id) {
        log.debug("Request to get Peticion : {}", id);
        return Optional.of(ModelMapperUtils.map(peticionRepository.findById(id).get(), PeticionDTO.class));

    }

    /**
     * Delete the peticion by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Peticion : {}", id);
        peticionRepository.deleteById(id);
    }

    /**
     * Get the historical of peticiones by usuario id for UsuarioDonante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<PeticionDTO> findAllByIdUsuarioDonanteEstadoCanceladoYAceptado(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.peticionRepository.findAllByIdUsuarioDonanteEstadoCanceladoYAceptado(idUsuario), PeticionDTO.class);
	}

	 /**
     * Get the historical of peticiones by usuario id for UsuarioEmpresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<PeticionDTO> findAllByIdUsuarioEmpresaEstadoCanceladoYAceptado(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.peticionRepository.findAllByIdUsuarioEmpresaEstadoCanceladoYAceptado(idUsuario), PeticionDTO.class);
	}

	   /**
     * Get the pendant peticiones by usuario id for UsuarioDonante.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<PeticionDTO> findAllByIdUsuarioDonanteEstadoPendiente(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.peticionRepository.findAllByIdUsuarioDonanteEstadoPendiente(idUsuario), PeticionDTO.class);
	}

	   /**
     * Get the pendant peticiones by usuario id for UsuarioEmpresa.
     *
     * @param idUsuario the usuario id
     * @return the list of entities.
     */
	@Override
	public List<PeticionDTO> findAllByIdUsuarioEmpresaEstadoPendiente(Long idUsuario) {
        return ModelMapperUtils.mapAll(this.peticionRepository.findAllByIdUsuarioDonanteEstadoPendiente(idUsuario), PeticionDTO.class);
	}

}
