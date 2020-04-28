package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.UsuarioEmpresa;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the UsuarioEmpresa entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresa, Long> {

    @Query(value = "Select * from usuario_empresa ue where ue.usuario_id = (select id from usuario where u.email = ?1)", nativeQuery = true)
    Optional<UsuarioEmpresa> findByEmailUsuario(String email);
}
