package br.com.caotica.exceptions;

/**
 * Entity in use exception
 * @author Thiago Pinheiro do Nascimento
 * @since 06 mar 2025
**/
public class EntityInUseException extends RuntimeException {

	/**
	 * Serial version id
	**/
	private static final long serialVersionUID = 1L;

	/**
	 * Exception constructor
	**/
	public EntityInUseException(String message) {
		super(message);
	}
}