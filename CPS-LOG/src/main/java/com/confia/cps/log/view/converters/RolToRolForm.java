package com.confia.cps.log.view.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.confia.cps.log.view.commands.RolForm;
import com.confia.cps.log.view.domain.Rol;

@Component
public class RolToRolForm implements Converter<Rol, RolForm> {
    @Override
    public RolForm convert(Rol entity) {
        RolForm form = new RolForm();
        
        form.setCodigoRol(entity.getCodigoRol());
        form.setNombreRol( entity.getNombreRol() );
 
        return form;
    }
}
