package com.confia.cps.log.view.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.confia.cps.log.view.commands.LogForm;
import com.confia.cps.log.view.domain.LogView;

@Component
public class LogToLogForm implements Converter<LogView, LogForm> {
    @Override
    public LogForm convert(LogView log) {
        LogForm logForm = new LogForm();
        
        logForm.setId(log.getId());
        logForm.setCategoria( log.getCategoria() );
        logForm.setFecha( log.getFecha() );
        logForm.setMensaje( log.getMensaje() );
        logForm.setOrigen( log.getOrigen() ) ;
        logForm.setIdentificacion( log.getIdentificacion());
        logForm.setValores( log.getValores() );
       
        return logForm;
    }
}
