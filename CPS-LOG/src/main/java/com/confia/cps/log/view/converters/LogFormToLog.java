package com.confia.cps.log.view.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.confia.cps.log.view.commands.LogForm;
import com.confia.cps.log.view.domain.LogView;

@Component
public class LogFormToLog implements Converter<LogForm, LogView> {

    @Override
    public LogView convert(LogForm logForm) {
        LogView log = new LogView();
        if (logForm.getId() != null  && !StringUtils.isEmpty(logForm.getId())) {
            log.setId(logForm.getId());
        }
  
        log.setCategoria( logForm.getCategoria() );
        log.setFecha( logForm.getFecha() );
        log.setMensaje( logForm.getMensaje() );
        log.setOrigen( logForm.getOrigen() ) ;
        log.setIdentificacion( logForm.getIdentificacion());
        log.setValores( logForm.getValores() );
               
        return log;
    }
}
