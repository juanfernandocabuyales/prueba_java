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
@Table(name = "TARJETA", schema = "PRUEBA")
@Getter
@Setter
public class Tarjeta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "TARJETA_ID_GENERATOR", sequenceName = "PRUEBA.TARJETA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TARJETA_ID_GENERATOR")
	@Column(name = "TARJETA_ID", unique = true, nullable = false, precision = 8)
	private Long tarjetaId;
	
	@Column(name = "TARJETA_NUMERO_VALIDACION", nullable = false, length = 1000)
	private String tarjetaNombre;
	
	@Column(name = "TARJETA_PAN", nullable = false, length = 1000)
	private String tarjetaPan;
	
	@Column(name = "TARJETA_ESTADO", nullable = false, length = 1000)
	private String tarjetaEstado;
	
	@Column(name = "TARJETA_TIPO", nullable = false, length = 1000)
	private String tarjetaTipo;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "TARJETA_TITULAR")
	private Titular tarjetaTitular;
}
