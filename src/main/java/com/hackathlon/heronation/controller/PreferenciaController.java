package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.service.PreferenciaService;
import com.hackathlon.heronation.model.dto.PreferenciaDTO;
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
 * REST controller for managing {@link com.hackathlon.heronation.model.Preferencia}.
 */
@RestController
@RequestMapping("/api")
public class PreferenciaController {

    private final Logger log = LoggerFactory.getLogger(com.hackathlon.heronation.controller.PreferenciaController.class);

    private static final String ENTITY_NAME = "preferencia";

    @Autowired
    private final PreferenciaService preferenciaService;

    public PreferenciaController(PreferenciaService preferenciaService) {
        this.preferenciaService = preferenciaService;
    }

    /**
     * {@code POST  /preferencias} : Create a new preferencia.
     *
     * @param preferenciaDTO the preferenciaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new preferenciaDTO, or with status {@code 400 (Bad Request)} if the preferencia has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/preferencias")
    public ResponseEntity<PreferenciaDTO> createPreferencia(@RequestBody PreferenciaDTO preferenciaDTO) throws URISyntaxException {
        log.debug("REST request to save Preferencia : {}", preferenciaDTO);
        if (preferenciaDTO.getId() != null) {
            throw new BadRequestAlertException("A new preferencia cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PreferenciaDTO result = preferenciaService.save(preferenciaDTO);
        return ResponseEntity.created(new URI("/api/preferencias/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /preferencias} : Updates an existing preferencia.
     *
     * @param preferenciaDTO the preferenciaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated preferenciaDTO,
     * or with status {@code 400 (Bad Request)} if the preferenciaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the preferenciaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/preferencias")
    public ResponseEntity<PreferenciaDTO> updatePreferencia(@RequestBody PreferenciaDTO preferenciaDTO) throws URISyntaxException {
        log.debug("REST request to update Preferencia : {}", preferenciaDTO);
        if (preferenciaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PreferenciaDTO result = preferenciaService.save(preferenciaDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /preferencias} : get all the preferencias.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of preferencias in body.
     */
    @GetMapping("/preferencias")
    public List<PreferenciaDTO> getAllPreferencias() {
        log.debug("REST request to get all Preferencias");
        return preferenciaService.findAll();
    }

    /**
     * {@code GET  /preferencias/:id} : get the "id" preferencia.
     *
     * @param id the id of the preferenciaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the preferenciaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/preferencias/{id}")
    public ResponseEntity<PreferenciaDTO> getPreferencia(@PathVariable Long id) {
        log.debug("REST request to get Preferencia : {}", id);
        Optional<PreferenciaDTO> preferenciaDTO = preferenciaService.findOne(id);
        return preferenciaDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));    }

    /**
     * {@code DELETE  /preferencias/:id} : delete the "id" preferencia.
     *
     * @param id the id of the preferenciaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/preferencias/{id}")
    public ResponseEntity<Void> deletePreferencia(@PathVariable Long id) {
        log.debug("REST request to delete Preferencia : {}", id);
        preferenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
