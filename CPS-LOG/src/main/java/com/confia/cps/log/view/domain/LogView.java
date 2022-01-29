package com.confia.cps.log.view.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.datastax.driver.core.DataType;

@Table("log")
public class LogView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey 
	@CassandraType(type = DataType.Name.UUID)
	private UUID id ;
	private String categoria;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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
	@Override
	public String toString() {
		return "LogView [id=" + id + ", categoria=" + categoria + ", fecha=" + fecha + ", mensaje=" + mensaje
				+ ", origen=" + origen + "]";
	}

    
}
