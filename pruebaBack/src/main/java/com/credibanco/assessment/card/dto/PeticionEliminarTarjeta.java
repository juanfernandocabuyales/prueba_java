package com.credibanco.assessment.card.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeticionEliminarTarjeta {

	private Long id;
	
	private String numeroValidacion;
	
	private String pan;
}
