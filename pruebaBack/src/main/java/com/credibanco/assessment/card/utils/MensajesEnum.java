package com.credibanco.assessment.card.utils;

import java.text.MessageFormat;

public enum MensajesEnum {

	CAMPO_REQUERIDO("El campo {0} es obligatorio"),
	CAMPO_VACIO("El campo {0} no puede ser vacio");
	
	private String mensaje;
	
	
	private MensajesEnum(String pMensaje) {
		mensaje = pMensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public String getMensajeFormat(Object... parametros ) {
		return MessageFormat.format(mensaje, parametros);
	}
}
