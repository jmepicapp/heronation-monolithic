package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.Poblacion;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Poblacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PoblacionRepository extends JpaRepository<Poblacion, Long> {
}
