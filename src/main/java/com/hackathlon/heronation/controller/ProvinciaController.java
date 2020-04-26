package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.service.ProvinciaService;
import com.hackathlon.heronation.model.dto.ProvinciaDTO;
import com.hackathlon.heronation.controller.error.BadRequestAlertException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    /**
     * {@code POST  /provincias} : Create a new provincia.
     *
     * @param provinciaDTO the provinciaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new provinciaDTO, or with status {@code 400 (Bad Request)} if the provincia has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/provincias")
    public ResponseEntity<ProvinciaDTO> createProvincia(@RequestBody ProvinciaDTO provinciaDTO) throws URISyntaxException {
        log.debug("REST request to save Provincia : {}", provinciaDTO);
        if (provinciaDTO.getId() != null) {
            throw new BadRequestAlertException("A new provincia cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProvinciaDTO result = provinciaService.save(provinciaDTO);
        return ResponseEntity.created(new URI("/api/provincias/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /provincias} : Updates an existing provincia.
     *
     * @param provinciaDTO the provinciaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated provinciaDTO,
     * or with status {@code 400 (Bad Request)} if the provinciaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the provinciaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/provincias")
    public ResponseEntity<ProvinciaDTO> updateProvincia(@RequestBody ProvinciaDTO provinciaDTO) throws URISyntaxException {
        log.debug("REST request to update Provincia : {}", provinciaDTO);
        if (provinciaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProvinciaDTO result = provinciaService.save(provinciaDTO);
        return ResponseEntity.ok().body(result);
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

    /**
     * {@code DELETE  /provincias/:id} : delete the "id" provincia.
     *
     * @param id the id of the provinciaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/provincias/{id}")
    public ResponseEntity<Void> deleteProvincia(@PathVariable Long id) {
        log.debug("REST request to delete Provincia : {}", id);
        provinciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
