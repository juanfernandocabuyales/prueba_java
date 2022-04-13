package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaCrearTarjeta extends RespuestaGenerica {

	private String numeroValidacion;
	
	private String pan;
	
	private Integer id;
}
