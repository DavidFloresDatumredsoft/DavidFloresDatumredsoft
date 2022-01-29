package com.confia.cps.log.view.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import com.confia.cps.log.view.commands.LogForm;
import com.confia.cps.log.view.converters.LogFormToLog;
import com.confia.cps.log.view.domain.LogView;
import com.confia.cps.log.view.repositories.LogRepository;

@Service
public class LogServiceImpl implements LogService{

    private LogRepository logRepository;
    private LogFormToLog logFormToLog;
    @Autowired
    private CassandraOperations cassandraTemplate;
    
    @Autowired
    public LogServiceImpl(LogRepository logRepository, LogFormToLog logFormToLog) {
        this.logRepository = logRepository;
        this.logFormToLog = logFormToLog;
    }


    @Override
    public List<LogView> listAll() {
        List<LogView> logs = new ArrayList<>();
        logRepository.findAll().forEach(logs::add);
        return logs;
    }
    
    
    public List<LogView> findIdentificacionFordocumentoIdAndTipoDocumentoId(String documentoId,String tipoDocumentoId) {
        
        String query = "SELECT * FROM log WHERE identificacion['documentoId'] = '"+documentoId+"' and identificacion['tipoDocumentoId']='"+tipoDocumentoId+"'allow filtering";
        List<LogView> logs  = cassandraTemplate.select( query, LogView.class );
        
        return logs;
    }

    @Override
    public LogView getById(UUID id) {
        return logRepository.findById(id).orElse(null);
    }

    @Override
    public LogView saveOrUpdate(LogView log) {
        logRepository.save(log);
        return log;
    }

    @Override
    public void delete(UUID id) {
        logRepository.deleteById(id);

    }

    @Override
    public LogView saveOrUpdateLogForm(LogForm logForm) {
        LogView savedLog = saveOrUpdate(logFormToLog.convert(logForm));

        System.out.println("Saved Product Id: " + savedLog.getId());
        return savedLog;
    }
}
