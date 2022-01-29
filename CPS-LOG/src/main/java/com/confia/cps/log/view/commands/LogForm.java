package com.confia.cps.log.view.commands;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class LogForm {

	private UUID id ;
	private String categoria;
	private LocalDateTime fecha;
	private String mensaje;
	private String origen;
	private Map<String, String> identificacion;
	private Map<String, String> valores;
	
	public UUID getId() {
		return id;
	}
	public String getCategoria() {
		return categoria;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public String getOrigen() {
		return origen;
	}
	public Map<String, String> getIdentificacion() {
		return identificacion;
	}
	public Map<String, String> getValores() {
		return valores;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setIdentificacion(Map<String, String> identificacion) {
		this.identificacion = identificacion;
	}
	public void setValores(Map<String, String> valores) {
		this.valores = valores;
	}
	
	
}
