package com.hackathlon.heronation.controller;

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
     * {@code POST  /poblacions} : Create a new poblacion.
     *
     * @param poblacionDTO the poblacionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new poblacionDTO, or with status {@code 400 (Bad Request)} if the poblacion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/poblacions")
    public ResponseEntity<PoblacionDTO> createPoblacion(@RequestBody PoblacionDTO poblacionDTO) throws URISyntaxException {
        log.debug("REST request to save Poblacion : {}", poblacionDTO);
        if (poblacionDTO.getId() != null) {
            throw new BadRequestAlertException("A new poblacion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PoblacionDTO result = poblacionService.save(poblacionDTO);
        return ResponseEntity.created(new URI("/api/poblacions/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /poblacions} : Updates an existing poblacion.
     *
     * @param poblacionDTO the poblacionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated poblacionDTO,
     * or with status {@code 400 (Bad Request)} if the poblacionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the poblacionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/poblacions")
    public ResponseEntity<PoblacionDTO> updatePoblacion(@RequestBody PoblacionDTO poblacionDTO) throws URISyntaxException {
        log.debug("REST request to update Poblacion : {}", poblacionDTO);
        if (poblacionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PoblacionDTO result = poblacionService.save(poblacionDTO);
        return ResponseEntity.ok().body(result);
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

    /**
     * {@code DELETE  /poblacions/:id} : delete the "id" poblacion.
     *
     * @param id the id of the poblacionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/poblacions/{id}")
    public ResponseEntity<Void> deletePoblacion(@PathVariable Long id) {
        log.debug("REST request to delete Poblacion : {}", id);
        poblacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
