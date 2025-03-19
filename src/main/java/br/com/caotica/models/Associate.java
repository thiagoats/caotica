package br.com.caotica.models;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	@CPF(message = "CPF é inválido")
	@NotBlank(message = "CPF é obrigatório")
	@Column(columnDefinition = "char(11)", nullable = false, updatable = false)
	private String cpf;
	
	/**
	 * Associate name
	**/
	@Length(min = 3, max = 50, message = "Nome deve conter entre 3 e 50 caracteres")
	@NotBlank(message = "Nome é obrigatório")
	@Column(length = 50, nullable = false)
	private String name;
	
	/**
	 * Associate birth
	**/
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Nascimento é obrigatório")
	@Column(columnDefinition = "date", nullable = false)
	private Date birth;
	
	/**
	 * Associate gender
	**/
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Sexo é obrigatório")
	@Column(columnDefinition = "char(3)", nullable = false)
	private Gender gender;
	
	/**
	 * Association between associate and address
	**/
	@Valid
	@OneToOne(mappedBy = "associate", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;
	
	/**
	 * Association between associate and contact
	**/
	@Valid
	@OneToOne(mappedBy = "associate", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Contact contact;
	
	/**
	 * Inserting the CPF mask after loading data
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@PostLoad
	private void postLoad() {
		this.cpf = this.cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})", "$1.$2.$3-");
	}
	
	/**
	 * Removing the CPF mask before persisting data
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@PrePersist @PreUpdate
	private void prePersisPreUpdate() {
		this.cpf = this.cpf.replaceAll("\\.|-", "");
	}
}