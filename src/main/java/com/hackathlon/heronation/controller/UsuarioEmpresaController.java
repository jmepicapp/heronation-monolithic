package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.model.dto.PreferenciaDTO;
import com.hackathlon.heronation.service.UsuarioEmpresaService;
import com.hackathlon.heronation.model.dto.UsuarioEmpresaDTO;
import com.hackathlon.heronation.controller.error.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.hackathlon.heronation.model.UsuarioEmpresa}.
 */
@RestController
@RequestMapping("/api")
public class UsuarioEmpresaController {

    private final Logger log = LoggerFactory.getLogger(UsuarioEmpresaController.class);

    private static final String ENTITY_NAME = "usuarioEmpresa";

    @Autowired
    private final UsuarioEmpresaService usuarioEmpresaService;

    public UsuarioEmpresaController(UsuarioEmpresaService usuarioEmpresaService) {
        this.usuarioEmpresaService = usuarioEmpresaService;
    }

    /**
     * {@code POST  /usuario-empresas} : Create a new usuarioEmpresa.
     *
     * @param usuarioEmpresaDTO the usuarioEmpresaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new usuarioEmpresaDTO, or with status {@code 400 (Bad Request)} if the usuarioEmpresa has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/usuario-empresas")
    public ResponseEntity<UsuarioEmpresaDTO> createUsuarioEmpresa(@RequestBody UsuarioEmpresaDTO usuarioEmpresaDTO) throws URISyntaxException {
        log.debug("REST request to save UsuarioEmpresa : {}", usuarioEmpresaDTO);
        if (usuarioEmpresaDTO.getId() != null) {
            throw new BadRequestAlertException("A new usuarioEmpresa cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UsuarioEmpresaDTO result = usuarioEmpresaService.save(usuarioEmpresaDTO);
        return ResponseEntity.created(new URI("/api/usuario-empresas/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /usuario-empresas} : Updates an existing usuarioEmpresa.
     *
     * @param usuarioEmpresaDTO the usuarioEmpresaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated usuarioEmpresaDTO,
     * or with status {@code 400 (Bad Request)} if the usuarioEmpresaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the usuarioEmpresaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/usuario-empresas")
    public ResponseEntity<UsuarioEmpresaDTO> updateUsuarioEmpresa(@RequestBody UsuarioEmpresaDTO usuarioEmpresaDTO) throws URISyntaxException {
        log.debug("REST request to update UsuarioEmpresa : {}", usuarioEmpresaDTO);
        if (usuarioEmpresaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UsuarioEmpresaDTO result = usuarioEmpresaService.save(usuarioEmpresaDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /usuario-empresas} : get all the usuarioEmpresas.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of usuarioEmpresas in body.
     */
    @GetMapping("/usuario-empresas")
    public ResponseEntity<List<UsuarioEmpresaDTO>> getAllUsuarioEmpresas(Pageable pageable) {
        log.debug("REST request to get a page of UsuarioEmpresas");
        List<UsuarioEmpresaDTO> list = usuarioEmpresaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    /**
     * {@code GET  /usuario-empresas/:id} : get the "id" usuarioEmpresa.
     *
     * @param id the id of the usuarioEmpresaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the usuarioEmpresaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/usuario-empresas/{id}")
    public ResponseEntity<UsuarioEmpresaDTO> getUsuarioEmpresa(@PathVariable Long id) {
        log.debug("REST request to get UsuarioEmpresa : {}", id);
        Optional<UsuarioEmpresaDTO> usuarioEmpresaDTO = usuarioEmpresaService.findOne(id);
        return usuarioEmpresaDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /usuario-empresas/:id} : delete the "id" usuarioEmpresa.
     *
     * @param id the id of the usuarioEmpresaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/usuario-empresas/{id}")
    public ResponseEntity<Void> deleteUsuarioEmpresa(@PathVariable Long id) {
        log.debug("REST request to delete UsuarioEmpresa : {}", id);
        usuarioEmpresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
