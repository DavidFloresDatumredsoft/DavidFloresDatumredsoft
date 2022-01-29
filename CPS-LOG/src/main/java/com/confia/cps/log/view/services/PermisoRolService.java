package com.confia.cps.log.view.services;

import java.util.UUID;

import com.confia.cps.log.view.commands.PermisoRolForm;
import com.confia.cps.log.view.domain.PermisoRol;

public interface PermisoRolService extends BasicService<PermisoRol,UUID>{
	PermisoRol saveOrUpdatePermisoRolForm(PermisoRolForm logForm);
	PermisoRol findUserAd(String serAD);
}
