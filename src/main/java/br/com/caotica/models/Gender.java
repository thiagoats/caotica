package br.com.caotica.models;

import lombok.Getter;

/**
 * Gender enum
 * @author Thiago Pinheiro do Nascimento
 * @since 13 feb 2025
**/
@Getter
public enum Gender {
	
	/**
	 * Available genders
	 * MAL - male gender
	 * FEM - female gender
	**/
	MAL("MAL", "Masculino"),
	FEM("FEM", "Feminino");
	
	/**
	 * Gender name
	**/
	private String name;
	
	/**
	 * Gender description
	**/
	private String description;
	
	/**
	 * Gender constructor
	**/
	private Gender(String name, String description) {
		this.name = name;
		this.description = description;
	}
}