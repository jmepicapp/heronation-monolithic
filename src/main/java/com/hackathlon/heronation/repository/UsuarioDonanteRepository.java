package com.hackathlon.heronation.repository;

import com.hackathlon.heronation.model.UsuarioDonante;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the UsuarioDonante entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsuarioDonanteRepository extends JpaRepository<UsuarioDonante, Long> {

    @Query(value = "Select * from usuario_donante ud where ud.usuario_id = (select id from usuario u where u.email = ?1)", nativeQuery = true)
    Optional<UsuarioDonante> findByEmailUsuario(String email);
}
