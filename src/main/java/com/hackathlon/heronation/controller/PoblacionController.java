package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.model.dto.ProvinciaDTO;
import com.hackathlon.heronation.service.PoblacionService;
import com.hackathlon.heronation.model.dto.PoblacionDTO;
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
 * REST controller for managing {@link com.hackathlon.heronation.model.Poblacion}.
 */
@RestController
@RequestMapping("/api")
public class PoblacionController {

    private final Logger log = LoggerFactory.getLogger(com.hackathlon.heronation.controller.PoblacionController.class);

    private static final String ENTITY_NAME = "poblacion";

    @Autowired
    private final PoblacionService poblacionService;

    public PoblacionController(PoblacionService poblacionService) {
        this.poblacionService = poblacionService;
    }

    /**
     * {@code GET  /poblacions} : get all the poblacions.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of poblacions in body.
     */
    @GetMapping("/poblacions")
    public List<PoblacionDTO> getAllPoblacions() {
        log.debug("REST request to get all Poblacions");
        return poblacionService.findAll();
    }

    /**
     * {@code GET  /poblacions/provincia/:id} : get all the poblaciones by the "provincia_id".
     *
     * @param id the id of the provinciaDTO to filter poblaciones.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of poblaciones by provincia in body.
     */
    @GetMapping("/poblacions/provincia/{id}")
    public List<PoblacionDTO> getAllPoblacionsByProvincia(@PathVariable Long id) {
        log.debug("REST request to get all Poblacions by Provincias");
        return poblacionService.findAllByProvincia(id);
    }

    /**
     * {@code GET  /poblacions/:id} : get the "id" poblacion.
     *
     * @param id the id of the poblacionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the poblacionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/poblacions/{id}")
    public ResponseEntity<PoblacionDTO> getPoblacion(@PathVariable Long id) {
        log.debug("REST request to get Poblacion : {}", id);
        Optional<PoblacionDTO> poblacionDTO = poblacionService.findOne(id);
        return poblacionDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
