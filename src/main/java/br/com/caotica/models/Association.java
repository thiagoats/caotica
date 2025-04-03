package br.com.caotica.models;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Association model class
 * @author Thiago Pinheiro do Nascimento
 * @since 20 feb 2025
**/
@Getter
@Setter
@Entity
@Table(name = "associations")
public class Association {

	/**
	 * Identifier used to differentiate the association
	**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Association registration date
	**/
	@Column(columnDefinition = "date", nullable = false)
	private Date register;
	
	/**
	 * Association start date
	**/
	@Column(columnDefinition = "date", nullable = false)
	private Date start;
	
	/**
	 * Association end date
	**/
	@Column(columnDefinition = "date", nullable = false)
	private Date end;
	
	/**
	 * Association amount
	**/
	@Column(nullable = false)
	private BigDecimal amount;
	
	/**
	 * Association type
	**/
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "char(4)", nullable = false)
	private Type type;
	
	/**
	 * Association between association and associate
	**/
	@ManyToOne
	@JoinColumn(name = "associates_id", nullable = false)
	private Associate associate;
}