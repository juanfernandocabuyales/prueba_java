package com.credibanco.assessment.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.PeticionCrearTarjeta;
import com.credibanco.assessment.card.dto.RespuestaCrearTarjeta;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.model.Titular;
import com.credibanco.assessment.card.repository.ITarjetaRepository;
import com.credibanco.assessment.card.repository.ITitularRepository;
import com.credibanco.assessment.card.service.impl.ITarjetaService;
import com.credibanco.assessment.card.utils.Constantes;
import com.credibanco.assessment.card.utils.Utilidades;

@Service
public class TarjetaService implements ITarjetaService {

	private ITarjetaRepository tarjetaRepository;
	
	private ITitularRepository titularRepository;
	
	@Autowired	
	public TarjetaService(ITarjetaRepository tarjetaRepository,ITitularRepository titularRepository) {
		this.tarjetaRepository = tarjetaRepository;
		this.titularRepository = titularRepository;
	}

	@Override
	public RespuestaCrearTarjeta crearTarjeta(PeticionCrearTarjeta peticionCrearTarjeta) {
		RespuestaCrearTarjeta respuestaCrearTarjeta = new RespuestaCrearTarjeta();
		try {
			Titular titular = new Titular();
			titular.setTitularCedula(peticionCrearTarjeta.getCedulaTitular());
			titular.setTitularNombre(peticionCrearTarjeta.getNombreTitular());
			titular.setTitularTelefono(peticionCrearTarjeta.getTelefonoTitular());
			titular = titularRepository.save(titular);
			
			Tarjeta tarjeta = new Tarjeta();
			tarjeta.setTarjetaNumeroValidacion(Utilidades.getInstance().generarNumeroValidacion(Constantes.LIMITE_INICIAL, Constantes.LIMITE_FINAL));
			tarjeta.setTarjetaPan(peticionCrearTarjeta.getPan());
			tarjeta.setTarjetaEstado(Constantes.ESTADO_CREADA);
			tarjeta.setTarjetaTipo(peticionCrearTarjeta.getTipo());
			tarjeta.setTarjetaTitular(titular);
			tarjeta = tarjetaRepository.save(tarjeta);
			
			respuestaCrearTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_CERO);
			respuestaCrearTarjeta.setMensaje(Constantes.RESPUESTA_EXITOSA);
			respuestaCrearTarjeta.setId(tarjeta.getTarjetaId().intValue());
			respuestaCrearTarjeta.setNumeroValidacion(tarjeta.getTarjetaNumeroValidacion());
			respuestaCrearTarjeta.setPan(Utilidades.getInstance().enmascararTexto(tarjeta.getTarjetaPan(), Constantes.INICIO_CODIGO_PAN, Constantes.FINAL_CODIGO_PAN, Constantes.CARACTER_ENMASCARAR));
		}catch(Exception e) {
			respuestaCrearTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
			respuestaCrearTarjeta.setMensaje(Constantes.RESPUESTA_FALLO);
		}
		return respuestaCrearTarjeta;
	}
}
