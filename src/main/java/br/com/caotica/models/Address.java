package br.com.caotica.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * Address model class
 * @author Thiago Pinheiro do Nascimento
 * @since 13 feb 2025
**/
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
	
	/**
	 * Identifier used to differentiate the address
	**/
	@Id
	@Column(name = "associates_id")
	private Long id;
	
	/**
	 * Address public place
	**/
	@Length(min = 5, max = 50, message = "Logradouro deve conter entre 5 e 50 caracteres")
	@NotBlank(message = "Logradouro é obrigatório")
	@Column(length = 50, nullable = false)
	private String place;
	
	/**
	 * Address complement
	**/
	@Length(max = 50, message = "Complemento deve conter no máximo 50 caracteres")
	@Column(length = 50)
	private String complement;
	
	/**
	 * Address district
	**/
	@Length(min = 3, max = 50, message = "Bairro deve conter entre 3 e 50 caracteres")
	@NotBlank(message = "Bairro é obrigatório")
	@Column(length = 50, nullable = false)
	private String district;
	
	/**
	 * Association between address and associate
	**/
	@OneToOne
	@MapsId
	@JoinColumn(name = "associates_id")
	private Associate associate;
}