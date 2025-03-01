package br.com.caotica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
	@Column(length = 50, nullable = false)
	private String place;
	
	/**
	 * Address complement
	**/
	@Column(length = 50)
	private String complement;
	
	/**
	 * Address district
	**/
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