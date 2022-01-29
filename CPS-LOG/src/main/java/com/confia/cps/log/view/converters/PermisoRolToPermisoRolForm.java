package com.confia.cps.log.view.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.confia.cps.log.view.commands.PermisoRolForm;
import com.confia.cps.log.view.domain.PermisoRol;

@Component
public class PermisoRolToPermisoRolForm implements Converter<PermisoRol, PermisoRolForm> {
    @Override
    public PermisoRolForm convert(PermisoRol entity) {
    	PermisoRolForm form = new PermisoRolForm();
        
        form.setId(entity.getId());
        form.setUsuarioAD( entity.getUsuarioAD() );
        form.setEstado(entity.getEstado());
        form.setNombreRol(entity.getNombreRol());
 
        return form;
    }
}
