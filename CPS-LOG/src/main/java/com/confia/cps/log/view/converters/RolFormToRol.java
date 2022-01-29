package com.confia.cps.log.view.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.confia.cps.log.view.commands.RolForm;
import com.confia.cps.log.view.domain.Rol;

@Component
public class RolFormToRol implements Converter<RolForm, Rol> {

    @Override
    public Rol convert(RolForm form) {
        Rol entity = new Rol();
        if (form.getCodigoRol() != null  && !StringUtils.isEmpty(form.getCodigoRol())) {
            entity.setCodigoRol(form.getCodigoRol());
        }
  
        entity.setNombreRol(form.getNombreRol());
        
        return entity;
    }
}
