package com.confia.cps.log.view.commands;

import java.util.ArrayList;
import java.util.List;

public class LogTable extends LogForm{
	
	private String documentoNumero;
	private String modificadoPor;
	private List<String> modificaciones = new ArrayList<String>();
	
	
	
	public List<String> getModificaciones() {
		return modificaciones;
	}
	
	public void setModificaciones(List<String> modificaciones) {
		this.modificaciones = modificaciones;
	}

	public String getDocumentoNumero() {
		return documentoNumero;
	}

	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}
	
	
	
}