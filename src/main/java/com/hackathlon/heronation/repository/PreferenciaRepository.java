package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.Preferencia;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Preferencia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PreferenciaRepository extends JpaRepository<Preferencia, Long> {
}
