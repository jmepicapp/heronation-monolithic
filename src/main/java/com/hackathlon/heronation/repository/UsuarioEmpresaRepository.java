package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.UsuarioEmpresa;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UsuarioEmpresa entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresa, Long> {
}
