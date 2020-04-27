package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.Preferencia;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Preferencia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PreferenciaRepository extends JpaRepository<Preferencia, Long> {

    @Query(value = "select * from preferencia pr where pr.usuario_empresa_id = :idUsuarioEmpresa", nativeQuery = true)
    List<Preferencia> findAllByUsuarioEmpresa(@Param("idUsuarioEmpresa") Long idUsuarioEmpresa);
}
