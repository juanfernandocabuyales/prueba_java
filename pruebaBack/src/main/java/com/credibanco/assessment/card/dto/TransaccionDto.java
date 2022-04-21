package com.credibanco.assessment.card.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransaccionDto {

	@NotNull(message = "El campo IdTarjeta debe ser obligatorio")
	private Long idTarjeta;

	@NotNull(message = "El campo Numero referencia debe ser obligatorio")
	private String numeroReferencia;

	@NotNull(message = "El campo total compra debe ser obligatorio")
	private Double totalCompra;

	@NotNull(message = "El campo direccion debe ser obligatorio")
	private String direccionCompra;
	
	private String fechaTransaccion;
}
