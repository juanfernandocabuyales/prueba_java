package com.credibanco.assessment.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.PeticionCrearTarjeta;
import com.credibanco.assessment.card.dto.PeticionEliminarTarjeta;
import com.credibanco.assessment.card.dto.PeticionEnrolarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaConsultarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaCrearTarjeta;
import com.credibanco.assessment.card.dto.RespuestaEliminarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaEnrolarTarjeta;
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
			respuestaCrearTarjeta.setId(tarjeta.getTarjetaId());
			respuestaCrearTarjeta.setNumeroValidacion(tarjeta.getTarjetaNumeroValidacion());
			respuestaCrearTarjeta.setPan(Utilidades.getInstance().enmascararTexto(tarjeta.getTarjetaPan(), Constantes.INICIO_CODIGO_PAN, Constantes.FINAL_CODIGO_PAN, Constantes.CARACTER_ENMASCARAR));
		}catch(Exception e) {
			respuestaCrearTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
			respuestaCrearTarjeta.setMensaje(Constantes.RESPUESTA_FALLO);
		}
		return respuestaCrearTarjeta;
	}

	@Override
	public RespuestaEnrolarTarjeta enrolarTarjeta(PeticionEnrolarTarjeta peticionEnrolarTarjeta) {
		RespuestaEnrolarTarjeta respuestaEnrolarTarjeta = new RespuestaEnrolarTarjeta();
		try {
			Tarjeta tarjeta = tarjetaRepository.findById(peticionEnrolarTarjeta.getId()).orElse(null);
			if(null == tarjeta) {
				respuestaEnrolarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
				respuestaEnrolarTarjeta.setMensaje(Constantes.TARJETA_NO_EXISTE);
			}else {
				if(!tarjeta.getTarjetaNumeroValidacion().equals(peticionEnrolarTarjeta.getNumeroValidacion())) {
					respuestaEnrolarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_DOS);
					respuestaEnrolarTarjeta.setMensaje(Constantes.NUMERO_VALIDACION_INCORRECTO);
				}else {
					tarjeta.setTarjetaEstado(Constantes.ESTADO_ENROLADA);
					tarjetaRepository.save(tarjeta);
					respuestaEnrolarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_CERO);
					respuestaEnrolarTarjeta.setMensaje(Constantes.RESPUESTA_EXITOSA);
					respuestaEnrolarTarjeta.setPan(Utilidades.getInstance().enmascararTexto(tarjeta.getTarjetaPan(), Constantes.INICIO_CODIGO_PAN, Constantes.FINAL_CODIGO_PAN, Constantes.CARACTER_ENMASCARAR));
				}
			}
		}catch(Exception e) {
			respuestaEnrolarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
			respuestaEnrolarTarjeta.setMensaje(Constantes.RESPUESTA_FALLO);
		}
		return respuestaEnrolarTarjeta;
	}

	@Override
	public RespuestaConsultarTarjeta consultarTarjeta(Long idTarjeta) {
		RespuestaConsultarTarjeta respuestaConsultarTarjeta = new RespuestaConsultarTarjeta();
		try {
			Tarjeta tarjeta = tarjetaRepository.findById(idTarjeta).orElse(null);
			if(null == tarjeta) {
				respuestaConsultarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
				respuestaConsultarTarjeta.setMensaje(Constantes.RESPUESTA_FALLO);
			}else {
				respuestaConsultarTarjeta.setPan(Utilidades.getInstance().enmascararTexto(tarjeta.getTarjetaPan(), Constantes.INICIO_CODIGO_PAN, Constantes.FINAL_CODIGO_PAN, Constantes.CARACTER_ENMASCARAR));
				respuestaConsultarTarjeta.setTitular(tarjeta.getTarjetaTitular().getTitularNombre());
				respuestaConsultarTarjeta.setCedula(tarjeta.getTarjetaTitular().getTitularCedula());
				respuestaConsultarTarjeta.setTelefono(tarjeta.getTarjetaTitular().getTitularTelefono());
				respuestaConsultarTarjeta.setEstado(tarjeta.getTarjetaEstado());
			}
		}catch(Exception e) {
			respuestaConsultarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
			respuestaConsultarTarjeta.setMensaje(Constantes.RESPUESTA_FALLO);
		}
		return respuestaConsultarTarjeta;
	}

	@Override
	public RespuestaEliminarTarjeta eliminarTarjeta(PeticionEliminarTarjeta peticionEliminarTarjeta) {
		RespuestaEliminarTarjeta respuestaEliminarTarjeta = new RespuestaEliminarTarjeta();
		try {
			Tarjeta tarjeta = tarjetaRepository.findById(peticionEliminarTarjeta.getId()).orElse(null);
			if(null == tarjeta) {
				respuestaEliminarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
				respuestaEliminarTarjeta.setMensaje(Constantes.VALIDACION_DATOS);
			}else {
				if(!tarjeta.getTarjetaNumeroValidacion().equals(peticionEliminarTarjeta.getNumeroValidacion())) {
					respuestaEliminarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
					respuestaEliminarTarjeta.setMensaje(Constantes.VALIDACION_DATOS);
				}else {
					if(!tarjeta.getTarjetaPan().equals(peticionEliminarTarjeta.getPan())) {
						respuestaEliminarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
						respuestaEliminarTarjeta.setMensaje(Constantes.VALIDACION_DATOS);
					}else {
						tarjetaRepository.delete(tarjeta);
						respuestaEliminarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_CERO);
						respuestaEliminarTarjeta.setMensaje(Constantes.ELIMINACION_OK);
					}
				}
			}
		}catch(Exception e) {
			respuestaEliminarTarjeta.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
			respuestaEliminarTarjeta.setMensaje(Constantes.RESPUESTA_FALLO);
		}
		return respuestaEliminarTarjeta;
	}
}
