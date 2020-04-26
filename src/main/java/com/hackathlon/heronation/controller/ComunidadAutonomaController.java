package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.controller.error.BadRequestAlertException;
import com.hackathlon.heronation.model.dto.ComunidadAutonomaDTO;
import com.hackathlon.heronation.service.ComunidadAutonomaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.hackathlon.heronation.model.ComunidadAutonoma}.
 */
@RestController
@RequestMapping("/api")
public class ComunidadAutonomaController {

    private final Logger log = LoggerFactory.getLogger(ComunidadAutonomaController.class);

    private static final String ENTITY_NAME = "comunidadAutonoma";

    @Autowired
    private final ComunidadAutonomaService comunidadAutonomaService;

    public ComunidadAutonomaController(ComunidadAutonomaService comunidadAutonomaService) {
        this.comunidadAutonomaService = comunidadAutonomaService;
    }

    /**
     * {@code GET  /comunidadAutonomas} : get all the comunidades autonomas.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of comunidades autonomas in body.
     */
    @GetMapping("/comunidadAutonomas")
    public List<ComunidadAutonomaDTO> getAllComunidadAutonomas() {
        log.debug("REST request to get all Comunidades Autonomas");
        return comunidadAutonomaService.findAll();
    }


    /**
     * {@code GET  /comunidadAutonomas/:id} : get the "id" comunidadAutonoma.
     *
     * @param id the id of the comunidadAutonomaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the comunidadAutonomaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/comunidadAutonomas/{id}")
    public ResponseEntity<ComunidadAutonomaDTO> getComunidadAutonoma(@PathVariable Long id) {
        log.debug("REST request to get Comunidad Autonoma : {}", id);
        Optional<ComunidadAutonomaDTO> comunidadAutonomaDTO = comunidadAutonomaService.findOne(id);
        return comunidadAutonomaDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
