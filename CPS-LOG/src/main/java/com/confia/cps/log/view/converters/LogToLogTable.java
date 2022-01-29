package com.confia.cps.log.view.converters;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.confia.cps.log.view.commands.LogForm;
import com.confia.cps.log.view.commands.LogTable;
import com.confia.cps.log.view.domain.LogView;

@Component
public class LogToLogTable implements Converter<LogView, LogForm> {
    @Override
    public LogTable convert(LogView log) {
    	LogTable logTable = new LogTable();
        logTable.setId( log.getId());
        logTable.setCategoria( log.getCategoria() );
        logTable.setFecha( log.getFecha() );
        logTable.setMensaje( log.getMensaje() );
        logTable.setOrigen( log.getOrigen() ) ;
        logTable.setIdentificacion( log.getIdentificacion());
        logTable.setValores( log.getValores() );
        logTable.setModificaciones(new ArrayList<String>());
        logTable.setDocumentoNumero(log.getIdentificacion() != null ? log.getIdentificacion().get("documentoId") : null );
        logTable.setModificadoPor( log.getValores() != null ? log.getValores().get("ADICIONADO_POR") : null );
        return logTable;
    }
}
