package com.confia.cps.log.view.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.confia.cps.log.view.commands.LogSearchForm;
import com.confia.cps.log.view.commands.LogTable;
import com.confia.cps.log.view.converters.LogToLogTable;
import com.confia.cps.log.view.domain.LogView;
import com.confia.cps.log.view.services.LogService;
import com.confia.cps.log.view.services.LoginActiveDirectory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/log"})
public class LogController {
    private LogService logService;
    @Autowired private LoginActiveDirectory ads;
    private LogToLogTable logToLogTable;
    
    List<LogTable> logTable = new ArrayList<>();
    
    @Value("${cps.ingorar.campo}")
    private String campos;
    @Value("${cps.rol.root.nombre}")
    private String rootRolApp;
    @Value("${cps.lista.documento}")
    private String documentosProperties;
    
    
    
    @Autowired
    public void setLogToLogTable(LogToLogTable logToLogTable) {
        this.logToLogTable = logToLogTable;
    }
    @Autowired
    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    @GetMapping({"/view"})
    public String filterLogs(Model model){
    	logTable = new ArrayList<>();
        model.addAttribute("logviews", logTable );
        model.addAttribute("formSearch", new LogSearchForm());
        return "logview/list";   
     }
    
    
    @PostMapping({"/view"})
    public String filterLogs(@ModelAttribute LogSearchForm form,Model model){
    	
    		List<LogView> logview = logService.findIdentificacionFordocumentoIdAndTipoDocumentoId(form.getNumDoc(), form.getTipoDoc());
    		logTable = new ArrayList<>();
	    	for( LogView item : logview ) {
	    		
	    		if (item.getValores() != null) {
		    		LogTable table = logToLogTable.convert(item);
	    			for (Map.Entry<String, String> entry : table.getValores().entrySet() ) {
	    		    	if ( entry.getValue() != null && !entry.getValue().equals("null") && !ignorarData(entry) ){
					    	table.getModificaciones().add(entry.toString());
					    }
					}
		    		
		    		logTable.add(table);
	    		}
				
	    	}
	    
	    model.addAttribute("formSearch", new LogSearchForm());
        model.addAttribute("logviews", logTable );
        return "logview/list";
    }
    
    @GetMapping("/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=CPS_LOG_CASSANDRA_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
         
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"DOCUMENTO", "FECHA", "CATEGORIA", "MENSAJE",	"ORIGEN","MODIFICADO POR","MODIFICADO EN"};
        String[] nameMapping = {"documentoNumero","fecha","categoria","mensaje","origen","modificadoPor","modificaciones"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (LogTable table : logTable) {
            csvWriter.write(table, nameMapping);
        }
         
        csvWriter.close();
         
    }
    
    /**
     * metodo que valida segun lista de valores si el campo se pondra dentro del grid
     * */
    private boolean ignorarData (Entry<String, String> entry) {
    	
    	for(String campo : campos.split(",")) {
    		if (entry.getKey().equals(campo) ) { 
    			return true;
    		}
    	}
    	return false;
    	
    }
    
    
    @GetMapping("/show/{id}")
    public String getLog(@PathVariable String id, Model model){
        model.addAttribute("logview", logService.getById(UUID.fromString(id)));
        return "logview/show";
    }

    @ModelAttribute("rootRolApp")
    public String getRootRolApp(){
    	return this.rootRolApp;
    }
    
    @ModelAttribute("listaDocumentos")
   public Map<String, String>  getDocumentos(){
    	Map<String, String> documentosMap = Arrays.stream(documentosProperties.split(","))
                .map(s -> s.split("="))
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));
    	return documentosMap;
    }
    
}
