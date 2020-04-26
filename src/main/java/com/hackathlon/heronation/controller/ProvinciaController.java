package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.service.ProvinciaService;
import com.hackathlon.heronation.model.dto.ProvinciaDTO;
import com.hackathlon.heronation.controller.error.BadRequestAlertException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.hackathlon.heronation.model.Provincia}.
 */
@RestController
@RequestMapping("/api")
public class ProvinciaController {

    private final Logger log = LoggerFactory.getLogger(com.hackathlon.heronation.controller.ProvinciaController.class);

    private static final String ENTITY_NAME = "provincia";

    @Autowired
    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    /**
     * {@code GET  /provincias} : get all the provincias.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of provincias in body.
     */
    @GetMapping("/provincias")
    public List<ProvinciaDTO> getAllProvincias() {
        log.debug("REST request to get all Provincias");
        return provinciaService.findAll();
    }

    /**
     * {@code GET  /provincias/comunidad/:id} : get all the provincias by the "comunidad_id".
     *
     * @param id the id of the comunidadDTO to filter provincias.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of provincias by in body.
     */
    @GetMapping("/provincias/comunidad/{id}")
    public List<ProvinciaDTO> getAllProvinciasByComunidad(@PathVariable Long id) {
        log.debug("REST request to get all Provincias by Comunidad Autonoma");
        return provinciaService.findAllByComunidad(id);
    }

    /**
     * {@code GET  /provincias/:id} : get the "id" provincia.
     *
     * @param id the id of the provinciaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the provinciaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/provincias/{id}")
    public ResponseEntity<ProvinciaDTO> getProvincia(@PathVariable Long id) {
        log.debug("REST request to get Provincia : {}", id);
        Optional<ProvinciaDTO> provinciaDTO = provinciaService.findOne(id);
        return provinciaDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
