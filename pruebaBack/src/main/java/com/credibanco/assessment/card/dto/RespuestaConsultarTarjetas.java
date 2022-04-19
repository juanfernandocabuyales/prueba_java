package com.credibanco.assessment.card.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaConsultarTarjetas extends RespuestaGenerica {

	private List<TarjetaDto> listTarjetasDto;
}
