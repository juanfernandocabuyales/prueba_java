package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.dto.PeticionCrearTarjeta;
import com.credibanco.assessment.card.dto.PeticionEliminarTarjeta;
import com.credibanco.assessment.card.dto.PeticionEnrolarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaConsultarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaCrearTarjeta;
import com.credibanco.assessment.card.dto.RespuestaEliminarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaEnrolarTarjeta;

public interface ITarjetaService {

	RespuestaCrearTarjeta crearTarjeta(PeticionCrearTarjeta peticionCrearTarjeta);
	
	RespuestaEnrolarTarjeta enrolarTarjeta(PeticionEnrolarTarjeta peticionEnrolarTarjeta);
	
	RespuestaConsultarTarjeta consultarTarjeta(Long idTarjeta);
	
	RespuestaEliminarTarjeta eliminarTarjeta(PeticionEliminarTarjeta peticionEliminarTarjeta);
}
