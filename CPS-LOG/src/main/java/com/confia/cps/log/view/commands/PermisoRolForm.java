package com.confia.cps.log.view.commands;

import java.util.UUID;

public class PermisoRolForm {
	
	private UUID id ;
	private String usuarioAD;
	private String estado;
	private String nombreRol;
	
	public UUID getId() {
		return id;
	}
	public String getUsuarioAD() {
		return usuarioAD;
	}
	public String getEstado() {
		return estado;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setUsuarioAD(String usuarioAD) {
		this.usuarioAD = usuarioAD;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	
}
