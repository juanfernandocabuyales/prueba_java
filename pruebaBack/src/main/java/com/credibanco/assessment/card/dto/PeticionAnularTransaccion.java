package com.credibanco.assessment.card.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeticionAnularTransaccion {

	@NotNull(message = "El campo idTtransaccion debe ser obligatorio")
	private Long idTtransaccion;
	
	@NotNull(message = "El campo numeroReferencia debe ser obligatorio")
	private String numeroReferencia;
	
	@NotNull(message = "El campo totalCompra debe ser obligatorio")
	private Double totalCompra;
}
