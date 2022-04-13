package com.credibanco.assessment.card.utils;

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
	
	public static void main(String[] args) {
		String resultado = Utilidades.getInstance().enmascararTexto("12345685233456", 6, 4, "*");
		System.out.println("resultado: " + resultado);
	}
}
