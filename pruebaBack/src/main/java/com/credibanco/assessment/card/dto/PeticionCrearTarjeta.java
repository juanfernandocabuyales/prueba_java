package com.credibanco.assessment.card.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeticionCrearTarjeta {

	@NotNull(message = "El campo PAN debe ser obligatorio")
	private String pan;
	
	@NotNull(message = "El campo Titular debe ser obligatorio")
	private String nombreTitular;
	
	@NotNull(message = "El campo Cedula debe ser obligatorio")
	private String cedulaTitular;
	
	@NotNull(message = "El campo Tipo debe ser obligatorio")
	private String tipo;
	
	@NotNull(message = "El campo Telefono debe ser obligatorio")
	private String telefonoTitular;
}
