package com.hackathlon.heronation.controller;

import com.hackathlon.heronation.service.CategoriaEmpresaService;
import com.hackathlon.heronation.model.dto.CategoriaEmpresaDTO;
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
 * REST controller for managing {@link com.hackathlon.heronation.model.CategoriaEmpresa}.
 */
@RestController
@RequestMapping("/api")
public class CategoriaEmpresaController {

    private final Logger log = LoggerFactory.getLogger(com.hackathlon.heronation.controller.CategoriaEmpresaController.class);

    private static final String ENTITY_NAME = "categoriaEmpresa";

    @Autowired
    private final CategoriaEmpresaService categoriaEmpresaService;

    public CategoriaEmpresaController(CategoriaEmpresaService categoriaEmpresaService) {
        this.categoriaEmpresaService = categoriaEmpresaService;
    }

    /**
     * {@code POST  /categoria-empresas} : Create a new categoriaEmpresa.
     *
     * @param categoriaEmpresaDTO the categoriaEmpresaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new categoriaEmpresaDTO, or with status {@code 400 (Bad Request)} if the categoriaEmpresa has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/categoria-empresas")
    public ResponseEntity<CategoriaEmpresaDTO> createCategoriaEmpresa(@RequestBody CategoriaEmpresaDTO categoriaEmpresaDTO) throws URISyntaxException {
        log.debug("REST request to save CategoriaEmpresa : {}", categoriaEmpresaDTO);
        if (categoriaEmpresaDTO.getId() != null) {
            throw new BadRequestAlertException("A new categoriaEmpresa cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CategoriaEmpresaDTO result = categoriaEmpresaService.save(categoriaEmpresaDTO);
        return ResponseEntity.created(new URI("/api/categoria-empresas/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /categoria-empresas} : Updates an existing categoriaEmpresa.
     *
     * @param categoriaEmpresaDTO the categoriaEmpresaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated categoriaEmpresaDTO,
     * or with status {@code 400 (Bad Request)} if the categoriaEmpresaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the categoriaEmpresaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/categoria-empresas")
    public ResponseEntity<CategoriaEmpresaDTO> updateCategoriaEmpresa(@RequestBody CategoriaEmpresaDTO categoriaEmpresaDTO) throws URISyntaxException {
        log.debug("REST request to update CategoriaEmpresa : {}", categoriaEmpresaDTO);
        if (categoriaEmpresaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CategoriaEmpresaDTO result = categoriaEmpresaService.save(categoriaEmpresaDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /categoria-empresas} : get all the categoriaEmpresas.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of categoriaEmpresas in body.
     */
    @GetMapping("/categoria-empresas")
    public List<CategoriaEmpresaDTO> getAllCategoriaEmpresas(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all CategoriaEmpresas");
        return categoriaEmpresaService.findAll();
    }

    /**
     * {@code GET  /categoria-empresas/:id} : get the "id" categoriaEmpresa.
     *
     * @param id the id of the categoriaEmpresaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the categoriaEmpresaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/categoria-empresas/{id}")
    public ResponseEntity<CategoriaEmpresaDTO> getCategoriaEmpresa(@PathVariable Long id) {
        log.debug("REST request to get CategoriaEmpresa : {}", id);
        Optional<CategoriaEmpresaDTO> categoriaEmpresaDTO = categoriaEmpresaService.findOne(id);
        return categoriaEmpresaDTO.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /categoria-empresas/:id} : delete the "id" categoriaEmpresa.
     *
     * @param id the id of the categoriaEmpresaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/categoria-empresas/{id}")
    public ResponseEntity<Void> deleteCategoriaEmpresa(@PathVariable Long id) {
        log.debug("REST request to delete CategoriaEmpresa : {}", id);
        categoriaEmpresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
