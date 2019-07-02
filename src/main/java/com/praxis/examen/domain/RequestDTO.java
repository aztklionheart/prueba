package com.praxis.examen.domain;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RequestDTO {
	
	@NotNull(message = "No puede ser Nulo")
	@ApiModelProperty(position = 1, required = true, value = "Nombre", example = "Mario")
	private String nombre;
	
	@NotNull(message = "No puede ser Nulo")
	@ApiModelProperty(position = 2, required = true, value = "Primer Apellido", example= "Perez")
	private String primerApellido;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	

}
