package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeticionCrearTransaccion {

	private Long idTarjeta;
	
	private String numeroReferencia;
	
	private Double totalCompra;
	
	private String direccionCompra;
}
