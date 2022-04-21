package com.credibanco.assessment.card.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utilidades {

	private static Utilidades utilidades;
	
	public Utilidades() {
		super();
	}
	
	public static Utilidades getInstance() {
		if(utilidades == null) {
			utilidades = new Utilidades();
		}
		return utilidades;
	}
	
	public String generarNumeroValidacion(Integer limiteInicial, Integer limiteFinal) {
		Integer numero = (int)(Math.random()*(limiteFinal - limiteInicial + 1) + limiteInicial);
		return String.valueOf(numero);
	}
	
	public String enmascararTexto(String texto, Integer digitosIniciales, Integer digitosFinales, String caracterer) {
		StringBuilder textoEnmascarado = new StringBuilder();
		String parteInicial = texto.substring(0, digitosIniciales);
		String parteFinal = texto.substring(texto.length() - digitosFinales, texto.length() );
		Integer cantidadCaracteres = Constantes.LIMITE_CODIGO_PAN - (digitosIniciales + digitosFinales);
		textoEnmascarado.append(parteInicial);
		for(int i = 0; i < cantidadCaracteres; i++) {
			textoEnmascarado.append(caracterer);
		}
		textoEnmascarado.append(parteFinal);
		return textoEnmascarado.toString();
	}
	
	public Long diferenciaMinutos(Date fechaInicial, Date fechaFinal ) {
		Long diferencia= fechaFinal.getTime() - fechaInicial.getTime() ;
		return TimeUnit.MILLISECONDS.toMinutes(diferencia);
	}
	
	public String formatearFecha(Date fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return format.format(fecha);
	}
	
	public static void main(String[] args) {
		/*String resultado = Utilidades.getInstance().enmascararTexto("12345685233456", 6, 4, "*");
		System.out.println("resultado: " + resultado);*/
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
			
			Date fechaUno = sdf.parse("2022-04-21 07:17");
			Date fechaDos = sdf.parse("2022-04-21 07:20");
			long diferencia= fechaDos.getTime() - fechaUno.getTime() ;
			long minutos = TimeUnit.MILLISECONDS.toMinutes(diferencia); 
			
			System.out.println("diferencia es: " + minutos);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
