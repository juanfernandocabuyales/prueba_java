package com.credibanco.assessment.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TRANSACCION", schema = "PRUEBA")
@Getter
@Setter
public class Transaccion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "TRANSACCION_ID_GENERATOR", sequenceName = "PRUEBA.TRANSACCION_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACCION_ID_GENERATOR")
	@Column(name = "TRANSACCION_ID", unique = true, nullable = false, precision = 8)
	private Long transaccionId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "TRANSACCION_TARJETA")
	private Tarjeta transaccionTarjeta;
	
	@Column(name = "TRANSACCION_REFERENCIA", nullable = false, length = 1000)
	private String transaccionReferencia;
	
	@Column(name = "TRANSACCION_VALOR", nullable = false, precision = 3)
	private Double transaccionValor;
	
	@Column(name = "TRANSACCION_DIRECCION", nullable = false, length = 1000)
	private String transaccionDireccion;
}
