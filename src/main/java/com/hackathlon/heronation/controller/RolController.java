package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.service.RolService;
import com.hackathlon.heronation.model.dto.RolDTO;
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
 * REST controller for managing {@link com.hackathlon.heronation.model.Rol}.
 */
@RestController
@RequestMapping("/api")
public class RolController {

    private final Logger log = LoggerFactory.getLogger(com.hackathlon.heronation.controller.RolController.class);

    private static final String ENTITY_NAME = "rol";

    @Autowired
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    /**
     * {@code POST  /rols} : Create a new rol.
     *
     * @param rolDTO the rolDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new rolDTO, or with status {@code 400 (Bad Request)} if the rol has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/rols")
    public ResponseEntity<RolDTO> createRol(@RequestBody RolDTO rolDTO) throws URISyntaxException {
        log.debug("REST request to save Rol : {}", rolDTO);
        if (rolDTO.getId() != null) {
            throw new BadRequestAlertException("A new rol cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RolDTO result = rolService.save(rolDTO);
        return ResponseEntity.created(new URI("/api/rols/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /rols} : Updates an existing rol.
     *
     * @param rolDTO the rolDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rolDTO,
     * or with status {@code 400 (Bad Request)} if the rolDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the rolDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/rols")
    public ResponseEntity<RolDTO> updateRol(@RequestBody RolDTO rolDTO) throws URISyntaxException {
        log.debug("REST request to update Rol : {}", rolDTO);
        if (rolDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RolDTO result = rolService.save(rolDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /rols} : get all the rols.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of rols in body.
     */
    @GetMapping("/rols")
    public List<RolDTO> getAllRols() {
        log.debug("REST request to get all Rols");
        return rolService.findAll();
    }

    /**
     * {@code GET  /rols/:id} : get the "id" rol.
     *
     * @param id the id of the rolDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the rolDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/rols/{id}")
    public ResponseEntity<RolDTO> getRol(@PathVariable Long id) {
        log.debug("REST request to get Rol : {}", id);
        Optional<RolDTO> rolDTO = rolService.findOne(id);
        return rolDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /rols/:id} : delete the "id" rol.
     *
     * @param id the id of the rolDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/rols/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        log.debug("REST request to delete Rol : {}", id);
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
