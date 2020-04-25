package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.CategoriaEmpresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the CategoriaEmpresa entity.
 */
@Repository
public interface CategoriaEmpresaRepository extends JpaRepository<CategoriaEmpresa, Long> {

    @Query(value = "select distinct categoriaEmpresa from CategoriaEmpresa categoriaEmpresa left join fetch categoriaEmpresa.usuarioEmpresas",
        countQuery = "select count(distinct categoriaEmpresa) from CategoriaEmpresa categoriaEmpresa")
    Page<CategoriaEmpresa> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct categoriaEmpresa from CategoriaEmpresa categoriaEmpresa left join fetch categoriaEmpresa.usuarioEmpresas")
    List<CategoriaEmpresa> findAllWithEagerRelationships();

    @Query("select categoriaEmpresa from CategoriaEmpresa categoriaEmpresa left join fetch categoriaEmpresa.usuarioEmpresas where categoriaEmpresa.id =:id")
    Optional<CategoriaEmpresa> findOneWithEagerRelationships(@Param("id") Long id);
}
