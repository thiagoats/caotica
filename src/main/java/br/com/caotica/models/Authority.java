package br.com.caotica.models;

import lombok.Getter;

/**
 * Authority enum
 * @author Thiago Pinheiro do Nascimento
 * @since 13 feb 2025
**/
@Getter
public enum Authority {
	
	/**
	 * Available authorities
	 * ADMIN - administrator authority
	 * INVIT - invited authority
	**/
	ADMIN("ADMIN", "Administrador"),
	INVIT("INVIT", "Convidado");
	
	/**
	 * Authority name
	**/
	private String name;
	
	/**
	 * Authority description
	**/
	private String description;
	
	/**
	 * Authority constructor
	**/
	private Authority(String name, String description) {
		this.name = name;
		this.description = description;
	}
}