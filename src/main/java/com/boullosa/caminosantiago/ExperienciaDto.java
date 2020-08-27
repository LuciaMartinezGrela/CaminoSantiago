package com.boullosa.caminosantiago;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExperienciaDto implements Serializable {

	private static final long serialVersionUID = -4149868914592954678L;

	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("experiencia")
	private String experiencia;

	public ExperienciaDto() {
	}

	public ExperienciaDto(String nombre, String experiencia) {
		super();
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	@JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}

	@JsonProperty("nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonProperty("experiencia")
	public String getExperiencia() {
		return experiencia;
	}

	@JsonProperty("experiencia")
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
}
