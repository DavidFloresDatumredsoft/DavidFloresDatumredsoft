package com.confia.cps.log.view.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.confia.cps.log.view.commands.PermisoRolForm;
import com.confia.cps.log.view.domain.PermisoRol;

@Component
public class PermisoRolFormToPermisoRol implements Converter<PermisoRolForm, PermisoRol> {

    @Override
    public PermisoRol convert(PermisoRolForm form) {
    	PermisoRol entity = new PermisoRol();
        if (form.getId() != null  && !StringUtils.isEmpty(form.getId())) {
            entity.setId(form.getId());
        }
  
        entity.setUsuarioAD( form.getUsuarioAD() );
        entity.setEstado(form.getEstado());
        entity.setNombreRol( form.getNombreRol() );
        
        return entity;
    }
}
