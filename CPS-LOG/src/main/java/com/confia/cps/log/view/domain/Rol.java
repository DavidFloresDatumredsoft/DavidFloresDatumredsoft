package com.confia.cps.log.view.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;

@Table("ROLES_AUD_AD")
public class Rol implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey 
	
	@Column("codigo_rol")
	private UUID codigo_Rol ;
	@CassandraType(type = DataType.Name.TEXT)
	@Column("NOMBRE_ROL")
	private String nombreRol;
	
	public UUID getCodigoRol() {
		return codigo_Rol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setCodigoRol(UUID codigoRol) {
		this.codigo_Rol = codigoRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	@Override
	public String toString() {
		return "Rol [codigoRol=" + codigo_Rol + ", nombreRol=" + nombreRol + "]";
	}
	
	
	
	
}
