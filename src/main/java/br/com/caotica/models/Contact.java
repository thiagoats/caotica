package br.com.caotica.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Contact model class
 * @author Thiago Pinheiro do Nascimento
 * @since 13 feb 2025
**/
@Getter
@Setter
@Entity
@Table(name = "contacts")
public class Contact {
	
	/**
	 * Identifier used to differentiate the contact
	**/
	@Id
	@Column(name = "associates_id")
	private Long id;
	
	/**
	 * Contact cellphone
	**/
	@Column(columnDefinition = "char(15)")
	private String cellphone;
	
	/**
	 * Contact telephone
	**/
	@Column(columnDefinition = "char(14)")
	private String telephone;
	
	/**
	 * Contact email
	**/
	@Email(message = "E-mail é inválido")
	@Length(min = 5, max = 50, message = "E-mail deve conter entre 5 e 50 caracteres")
	@NotBlank(message = "E-mail é obrigatório")
	@Column(length = 50, nullable = false)
	private String email;
	
	/**
	 * Association between contact and associate
	**/
	@OneToOne
	@MapsId
	@JoinColumn(name = "associates_id")
	private Associate associate;
}