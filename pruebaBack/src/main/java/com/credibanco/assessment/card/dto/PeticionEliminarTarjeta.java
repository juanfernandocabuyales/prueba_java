package com.credibanco.assessment.card.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeticionEliminarTarjeta {

	@NotNull(message = "El campo id debe ser obligatorio")
	private Long id;
	
	@NotNull(message = "El campo numeroValidacion debe ser obligatorio")
	private String numeroValidacion;
	
	@NotNull(message = "El campo PAN debe ser obligatorio")
	private String pan;
}
