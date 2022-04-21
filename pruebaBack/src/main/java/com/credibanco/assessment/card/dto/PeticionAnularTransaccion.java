package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeticionAnularTransaccion {

	private Long idTtransaccion;
	
	private String numeroReferencia;
	
	private Double totalCompra;
}
