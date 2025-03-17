package br.com.caotica.exceptions;

import lombok.Getter;

/**
 * Entity with errors exception
 * @author Thiago Pinheiro do Nascimento
 * @since 13 mar 2025
**/
@Getter
public class EntityWithErrorsException extends Exception {

	/**
	 * Serial version id
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * Erroneous property
	**/
	private String property;
	
	/**
	 * Exception constructor
	**/
	public EntityWithErrorsException(String property, String message) {
		super(message);
		this.property = property;
	}
}