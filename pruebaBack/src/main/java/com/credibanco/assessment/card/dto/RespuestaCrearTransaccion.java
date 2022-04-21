package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaCrearTransaccion extends RespuestaGenerica {

	private String estado;
	
	private String numeroReferencia;
}
