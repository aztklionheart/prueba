package com.praxis.examen.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResponseDTO {
	
	@ApiModelProperty(position = 1, required = true, value = "Nombre")
	private String nombre;
	@ApiModelProperty(position = 2, required = true, value = "Primer Apellido")
	private String primerApellido;
	@ApiModelProperty(position = 3, required = true, value = "Segundo Apellido")
	private String segundoApellido;
	@ApiModelProperty(position = 4, required = true, value = "Edad")
	private int edad;
	
	
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
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
