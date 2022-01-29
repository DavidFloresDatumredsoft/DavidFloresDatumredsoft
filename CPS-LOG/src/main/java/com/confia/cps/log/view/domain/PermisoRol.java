package com.confia.cps.log.view.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;


@Table("PERMISOS_ROLES_AUD_AD")
public class PermisoRol implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@PrimaryKey 
	@CassandraType(type = DataType.Name.UUID)
	@Column("CODIGO_PERMISO")
	private UUID codigo_permiso;
	@CassandraType(type = DataType.Name.TEXT)
	@Column("NOMBRE_ROL")
	private String nombreRol;
	@CassandraType(type = DataType.Name.TEXT)
	@Column("usuarioAD")
	private String usuarioAD;
	@CassandraType(type = DataType.Name.TEXT)
	@Column("estado")
	private String estado;
	
	
	public UUID getId() {
		return codigo_permiso;
	}
	public String getUsuarioAD() {
		return usuarioAD;
	}
	public String getEstado() {
		return estado;
	}
	public void setId(UUID id) {
		this.codigo_permiso = id;
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
