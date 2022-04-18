package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaConsultarTarjeta extends RespuestaGenerica {

	private String pan;
	
	private String titular;
	
	private String cedula;
	
	private String telefono;
	
	private String estado;
}
