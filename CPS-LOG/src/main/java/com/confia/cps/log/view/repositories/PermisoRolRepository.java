package com.confia.cps.log.view.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.confia.cps.log.view.domain.PermisoRol;

public interface PermisoRolRepository extends CrudRepository<PermisoRol, UUID> {
	PermisoRol findByUsuarioAD(String usuarioAD);
}
