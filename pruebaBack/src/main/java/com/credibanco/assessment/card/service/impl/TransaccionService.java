package com.credibanco.assessment.card.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.dto.PeticionAnularTransaccion;
import com.credibanco.assessment.card.dto.PeticionCrearTransaccion;
import com.credibanco.assessment.card.dto.RespuestaAnularTransaccion;
import com.credibanco.assessment.card.dto.RespuestaCrearTransaccion;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.model.Transaccion;
import com.credibanco.assessment.card.repository.ITarjetaRepository;
import com.credibanco.assessment.card.repository.ITransaccionRepository;
import com.credibanco.assessment.card.service.ITransaccionService;
import com.credibanco.assessment.card.utils.Constantes;
import com.credibanco.assessment.card.utils.Utilidades;

@Service
public class TransaccionService implements ITransaccionService {
	
	@Autowired
	private ITransaccionRepository transaccionRepository;
	
	@Autowired
	private ITarjetaRepository tarjetaRepository;

	@Override
	public RespuestaCrearTransaccion crearTransaccion(PeticionCrearTransaccion peticionCrearTransaccion) {
		RespuestaCrearTransaccion respuestaCrearTransaccion = new RespuestaCrearTransaccion();
		try {			
			Tarjeta tarjeta = tarjetaRepository.findById(peticionCrearTransaccion.getIdTarjeta()).orElse(null);
			if(null == tarjeta) {
				respuestaCrearTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
				respuestaCrearTransaccion.setMensaje(Constantes.TARJETA_NO_EXISTE);
				respuestaCrearTransaccion.setEstado(Constantes.ESTADO_RECHAZADA);
				respuestaCrearTransaccion.setNumeroReferencia(peticionCrearTransaccion.getNumeroReferencia());	
			}else {
				if(!tarjeta.getTarjetaEstado().equalsIgnoreCase(Constantes.ESTADO_ENROLADA)) {
					respuestaCrearTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_DOS);
					respuestaCrearTransaccion.setMensaje(Constantes.TARJETA_SIN_ENROLAR);
					respuestaCrearTransaccion.setEstado(Constantes.ESTADO_RECHAZADA);
					respuestaCrearTransaccion.setNumeroReferencia(peticionCrearTransaccion.getNumeroReferencia());
				}else {
					Transaccion transaccion = new Transaccion();
					transaccion.setTransaccionReferencia(peticionCrearTransaccion.getNumeroReferencia());
					transaccion.setTransaccionDireccion(peticionCrearTransaccion.getDireccionCompra());
					transaccion.setTransaccionValor(peticionCrearTransaccion.getTotalCompra());	
					transaccion.setTransaccionTarjeta(tarjeta);
					transaccion.setTransaccionEstado(Constantes.ESTADO_APROBADA);
					transaccion.setTransaccionFecha(new Date());
					transaccion = transaccionRepository.save(transaccion);
					
					respuestaCrearTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_CERO);
					respuestaCrearTransaccion.setMensaje(Constantes.COMPRA_EXITOSA);
					respuestaCrearTransaccion.setEstado(Constantes.ESTADO_APROBADA);
					respuestaCrearTransaccion.setNumeroReferencia(peticionCrearTransaccion.getNumeroReferencia());
				}
			}
		}catch(Exception e) {
			respuestaCrearTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
			respuestaCrearTransaccion.setMensaje(Constantes.RESPUESTA_FALLO);
		}
		return respuestaCrearTransaccion;
	}

	@Override
	public RespuestaAnularTransaccion anularTransaccion(PeticionAnularTransaccion peticionAnularTransaccion) {
		RespuestaAnularTransaccion respuestaAnularTransaccion = new RespuestaAnularTransaccion();
		try {
			Transaccion transaccion = transaccionRepository.findById(peticionAnularTransaccion.getIdTtransaccion()).orElse(null);
			if(null == transaccion) {
				respuestaAnularTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
				respuestaAnularTransaccion.setMensaje(Constantes.TRANSACCION_NO_EXISTE);
				respuestaAnularTransaccion.setNumeroReferencia(peticionAnularTransaccion.getNumeroReferencia());	
			}else {
				if(!transaccion.getTransaccionReferencia().equalsIgnoreCase(peticionAnularTransaccion.getNumeroReferencia())) {
					respuestaAnularTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
					respuestaAnularTransaccion.setMensaje(Constantes.NUMERO_REFERENCIA_INCORRECTO);
					respuestaAnularTransaccion.setNumeroReferencia(peticionAnularTransaccion.getNumeroReferencia());
				}else {
					Date fechaTransaccion = transaccion.getTransaccionFecha();
					Date fechaActual = new Date();
					Long diferencia = Utilidades.getInstance().diferenciaMinutos(fechaTransaccion, fechaActual);
					if(diferencia > Constantes.LIMITE_TIEMPO_MINUTOS) {
						respuestaAnularTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_DOS);
						respuestaAnularTransaccion.setMensaje(Constantes.TRANSACCION_INVALIDA);
						respuestaAnularTransaccion.setNumeroReferencia(peticionAnularTransaccion.getNumeroReferencia());
					}else {
						transaccion.setTransaccionEstado(Constantes.ESTADO_ANULADA);
						transaccionRepository.save(transaccion);
						respuestaAnularTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_CERO);
						respuestaAnularTransaccion.setMensaje(Constantes.COMPRA_ANULADA);
						respuestaAnularTransaccion.setNumeroReferencia(peticionAnularTransaccion.getNumeroReferencia());
					}
				}
			}
		}catch(Exception e) {
			respuestaAnularTransaccion.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_UNO);
			respuestaAnularTransaccion.setMensaje(Constantes.RESPUESTA_FALLO);
		}
		return respuestaAnularTransaccion;
	}

}
