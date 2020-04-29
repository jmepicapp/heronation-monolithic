package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.controller.error.BadRequestAlertException;
import com.hackathlon.heronation.model.dto.UsuarioDonanteDTO;
import com.hackathlon.heronation.model.dto.UsuarioDonanteFrontDTO;
import com.hackathlon.heronation.service.UsuarioDonanteService;

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
 * REST controller for managing {@link com.hackathlon.heronation.model.UsuarioDonante}.
 */
@RestController
@RequestMapping("/api")
public class UsuarioDonanteController {

    private final Logger log = LoggerFactory.getLogger(UsuarioDonanteController.class);

    private static final String ENTITY_NAME = "usuarioDonante";

    @Autowired
    private final UsuarioDonanteService usuarioDonanteService;

    public UsuarioDonanteController(UsuarioDonanteService usuarioDonanteService) {
        this.usuarioDonanteService = usuarioDonanteService;
    }

    /**
     * {@code POST  /usuario-donantes} : Create a new usuarioDonante.
     *
     * @param usuarioDonanteFrontDTO the usuarioDonanteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new usuarioDonanteDTO, or with status {@code 400 (Bad Request)} if the usuarioDonante has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/usuario-donantes")
    public ResponseEntity<UsuarioDonanteDTO> createUsuarioDonante(@RequestBody UsuarioDonanteFrontDTO usuarioDonanteFrontDTO) throws URISyntaxException {
        log.debug("REST request to save UsuarioDonante : {}", usuarioDonanteFrontDTO);
        UsuarioDonanteDTO result = usuarioDonanteService.save(usuarioDonanteFrontDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code PUT  /usuario-donantes} : Updates an existing usuarioDonante.
     *
     * @param usuarioDonanteFrontDTO the usuarioDonanteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated usuarioDonanteDTO,
     * or with status {@code 400 (Bad Request)} if the usuarioDonanteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the usuarioDonanteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/usuario-donantes")
    public ResponseEntity<UsuarioDonanteDTO> updateUsuarioDonante(@RequestBody UsuarioDonanteFrontDTO usuarioDonanteFrontDTO) throws URISyntaxException {
        log.debug("REST request to update UsuarioDonante : {}", usuarioDonanteFrontDTO);
        UsuarioDonanteDTO result = usuarioDonanteService.save(usuarioDonanteFrontDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /usuario-donantes} : get all the usuarioDonantes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of usuarioDonantes in body.
     */
    @GetMapping("/usuario-donantes")
    public List<UsuarioDonanteDTO> getAllUsuarioDonantes() {
        log.debug("REST request to get all UsuarioDonantes");
        return usuarioDonanteService.findAll();
    }

    /**
     * {@code GET  /usuario-donantes/:id} : get the "id" usuarioDonante.
     *
     * @param id the id of the usuarioDonanteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the usuarioDonanteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/usuario-donantes/{id}")
    public ResponseEntity<UsuarioDonanteDTO> getUsuarioDonante(@PathVariable Long id) {
        log.debug("REST request to get UsuarioDonante : {}", id);
        Optional<UsuarioDonanteDTO> usuarioDonanteDTO = usuarioDonanteService.findOne(id);
        return usuarioDonanteDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code GET  /usuario-donantes/email/{emailUsuario}} : get the "id" usuarioDonante.
     *
     * @param emailUsuario the id of the usuario to filter the UsuarioDonanteDTO.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the usuarioDonanteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/usuario-donantes/email/{emailUsuario}")
    public ResponseEntity<UsuarioDonanteDTO> getUsuarioDonanteByEmailUsuario(@PathVariable String emailUsuario) {
        log.debug("REST request to get UsuarioDonante : {}", emailUsuario);
        Optional<UsuarioDonanteDTO> usuarioDonanteDTO = usuarioDonanteService.findByEmailUsuario(emailUsuario);
        return usuarioDonanteDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /usuario-donantes/:id} : delete the "id" usuarioDonante.
     *
     * @param id the id of the usuarioDonanteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/usuario-donantes/{id}")
    public ResponseEntity<Void> deleteUsuarioDonante(@PathVariable Long id) {
        log.debug("REST request to delete UsuarioDonante : {}", id);
        usuarioDonanteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
