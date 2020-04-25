package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.domain.UsuarioDonante;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UsuarioDonante entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsuarioDonanteRepository extends JpaRepository<UsuarioDonante, Long> {
}
