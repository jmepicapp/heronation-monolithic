package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.ComunidadAutonoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Provincia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ComunidadAutonomaRepository extends JpaRepository<ComunidadAutonoma, Long> {
}
