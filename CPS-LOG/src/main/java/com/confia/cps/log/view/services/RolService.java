package com.confia.cps.log.view.services;

import java.util.UUID;

import com.confia.cps.log.view.commands.RolForm;
import com.confia.cps.log.view.domain.Rol;

public interface RolService extends BasicService<Rol, UUID>{
	Rol saveOrUpdateRolForm(RolForm form);
}
