package br.com.caotica.exceptions;

/**
 * Entity not found exception
 * @author Thiago Pinheiro do Nascimento
 * @since 06 mar 2025
**/
public class EntityNotFoundException extends RuntimeException {

	/**
	 * Serial version id
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * Exception constructor
	**/
	public EntityNotFoundException(String message) {
		super(message);
	}
}