package com.credibanco.assessment.card.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaConsultarTransacciones extends RespuestaGenerica {

	private List<TransaccionDto> transaccionesList;
}
