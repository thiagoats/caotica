package br.com.caotica.models;

import lombok.Getter;

/**
 * Type enum
 * @author Thiago Pinheiro do Nascimento
 * @since 20 feb 2025
**/
@Getter
public enum Type {
	
	/**
	 * Available types
	 * INST - professor type
	 * STUD - student type
	 * TECH - technician type
	**/
	INST("INST", "Professor"),
	STUD("STUD", "Estudante"),
	TECH("TECH", "Técnico");
	
	/**
	 * Type name
	**/
	private String name;
	
	/**
	 * Type description
	**/
	private String description;
	
	/**
	 * Type constructor
	**/
	private Type(String name, String description) {
		this.name = name;
		this.description = description;
	}
}