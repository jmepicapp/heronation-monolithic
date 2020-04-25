package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.service.PeticionService;
import com.hackathlon.heronation.model.dto.PeticionDTO;
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
 * REST controller for managing {@link com.hackathlon.heronation.model.Peticion}.
 */
@RestController
@RequestMapping("/api")
public class PeticionController {

    private final Logger log = LoggerFactory.getLogger(PeticionController.class);

    private static final String ENTITY_NAME = "peticion";

    @Autowired
    private final PeticionService peticionService;

    public PeticionController(PeticionService peticionService) {
        this.peticionService = peticionService;
    }

    /**
     * {@code POST  /peticions} : Create a new peticion.
     *
     * @param peticionDTO the peticionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new peticionDTO, or with status {@code 400 (Bad Request)} if the peticion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/peticions")
    public ResponseEntity<PeticionDTO> createPeticion(@RequestBody PeticionDTO peticionDTO) throws URISyntaxException {
        log.debug("REST request to save Peticion : {}", peticionDTO);
        if (peticionDTO.getId() != null) {
            throw new BadRequestAlertException("A new peticion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PeticionDTO result = peticionService.save(peticionDTO);
        return ResponseEntity.created(new URI("/api/peticions/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /peticions} : Updates an existing peticion.
     *
     * @param peticionDTO the peticionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated peticionDTO,
     * or with status {@code 400 (Bad Request)} if the peticionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the peticionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/peticions")
    public ResponseEntity<PeticionDTO> updatePeticion(@RequestBody PeticionDTO peticionDTO) throws URISyntaxException {
        log.debug("REST request to update Peticion : {}", peticionDTO);
        if (peticionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PeticionDTO result = peticionService.save(peticionDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /peticions} : get all the peticions.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of peticions in body.
     */
    @GetMapping("/peticions")
    public List<PeticionDTO> getAllPeticions() {
        log.debug("REST request to get all Peticions");
        return peticionService.findAll();
    }

    /**
     * {@code GET  /peticions/:id} : get the "id" peticion.
     *
     * @param id the id of the peticionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the peticionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/peticions/{id}")
    public ResponseEntity<PeticionDTO> getPeticion(@PathVariable Long id) {
        log.debug("REST request to get Peticion : {}", id);
        Optional<PeticionDTO> peticionDTO = peticionService.findOne(id);
        return peticionDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /peticions/:id} : delete the "id" peticion.
     *
     * @param id the id of the peticionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/peticions/{id}")
    public ResponseEntity<Void> deletePeticion(@PathVariable Long id) {
        log.debug("REST request to delete Peticion : {}", id);
        peticionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
