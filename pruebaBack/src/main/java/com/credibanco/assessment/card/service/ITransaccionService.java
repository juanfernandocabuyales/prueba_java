package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.PeticionAnularTransaccion;
import com.credibanco.assessment.card.dto.PeticionCrearTransaccion;
import com.credibanco.assessment.card.dto.RespuestaAnularTransaccion;
import com.credibanco.assessment.card.dto.RespuestaConsultarTransacciones;
import com.credibanco.assessment.card.dto.RespuestaCrearTransaccion;

public interface ITransaccionService {

	RespuestaCrearTransaccion crearTransaccion(PeticionCrearTransaccion peticionCrearTransaccion);
	
	RespuestaAnularTransaccion anularTransaccion(PeticionAnularTransaccion peticionAnularTransaccion);
	
	RespuestaConsultarTransacciones consultarTransacciones();
}
