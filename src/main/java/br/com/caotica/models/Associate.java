package br.com.caotica.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Associate model class
 * @author Thiago Pinheiro do Nascimento
 * @since 13 feb 202
**/
@Getter
@Setter
@Entity
@Table(name = "associates")
public class Associate {
	
	/**
	 * Identifier used to differentiate the associate
	**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Associate cpf
	**/
	@Column(columnDefinition = "char(11)", nullable = false, updatable = false)
	private String cpf;
	
	/**
	 * Associate name
	**/
	@Column(length = 50, nullable = false)
	private String name;
	
	/**
	 * Associate birth
	**/
	@Column(columnDefinition = "date", nullable = false)
	private Date birth;
	
	/**
	 * Associate gender
	**/
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "char(3)", nullable = false)
	private Gender gender;
	
	/**
	 * Association between associate and address
	**/
	@OneToOne(mappedBy = "associate", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
	
	/**
	 * Association between associate and contact
	**/
	@OneToOne(mappedBy = "associate", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Contact contact;
}