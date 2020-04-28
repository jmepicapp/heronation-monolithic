package com.hackathlon.heronation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hackathlon.heronation.model.Peticion;

/**
 * Spring Data  repository for the Peticion entity.
 */
@Repository
public interface PeticionRepository extends JpaRepository<Peticion, Long> {

	@Query(value ="select * from Peticion p where p.usuario_donante_id IN "+"(select id from UsuarioDonante ud where ud.id = p.usuario_donante_id)",nativeQuery = true)
	List<Peticion> findAllByIdUsuario(Long idUsuario);
	
	@Query(value ="select p from Peticion p where p.estado = 'PENDIENTE'")
	List<Peticion> findAllByEstadoPendiente();
	
	@Query(value ="select * from Peticion p where (p.estado = 'CANCELADO' or p.estado = 'ACEPTADO') and p.usuario_donante_id IN "+"(select id from UsuarioDonante ud where ud.id = p.usuario_donante_id)",nativeQuery = true)
	List<Peticion> findAllByIdUsuarioDonanteEstadoCanceladoYAceptado(Long idUsuario);
	
	@Query(value ="select * from Peticion p where (p.estado = 'CANCELADO' or p.estado = 'ACEPTADO') and p.usuario_empresa_id IN "+"(select id from UsuarioEmpresa ue where ue.id = p.usuario_empresa_id)",nativeQuery = true)
	List<Peticion> findAllByIdUsuarioEmpresaEstadoCanceladoYAceptado(Long idUsuario);
	
	@Query(value ="select * from Peticion p where p.estado = 'PENDIENTE' and p.usuario_donante_id IN "+"(select id from UsuarioDonante ud where ud.id = p.usuario_donante_id)",nativeQuery = true)
	List<Peticion> findAllByIdUsuarioDonanteEstadoPendiente(Long idUsuario);
	
	@Query(value ="select * from Peticion p where p.estado = 'PENDIENTE' and p.usuario_empresa_id IN "+"(select id from UsuarioEmpresa ue where ue.id = p.usuario_empresa_id)",nativeQuery = true)
	List<Peticion> findAllByIdUsuarioEmpresaEstadoPendiente(Long idUsuario);
	
};