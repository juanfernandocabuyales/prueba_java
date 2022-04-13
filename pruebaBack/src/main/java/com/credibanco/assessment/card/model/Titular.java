package com.credibanco.assessment.card.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TITULAR", schema = "PRUEBA")
@Getter
@Setter
public class Titular implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "TITULAR_ID_GENERATOR", sequenceName = "PRUEBA.TITULAR_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TITULAR_ID_GENERATOR")
	@Column(name = "TITULAR_ID", unique = true, nullable = false, precision = 8)
	private Long titularId;
	
	@Column(name = "TITULAR_NOMBRE", nullable = false, length = 1000)
	private String titularNombre;
	
	@Column(name = "TITULAR_CEDULA", nullable = false, length = 100)
	private String titularCedula;
	
	@Column(name = "TITULAR_TELEFONO", nullable = false, length = 100)
	private String titularTelefono;
}
