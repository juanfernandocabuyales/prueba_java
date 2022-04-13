package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.dto.PeticionCrearTarjeta;
import com.credibanco.assessment.card.dto.RespuestaCrearTarjeta;

public interface ITarjetaService {

	RespuestaCrearTarjeta crearTarjeta(PeticionCrearTarjeta peticionCrearTarjeta);
}
