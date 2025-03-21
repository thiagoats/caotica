package br.com.caotica.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * User model class
 * @author Thiago Pinheiro do Nascimento
 * @since 13 feb 2025
**/
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	
	/**
	 * Identifier used to differentiate the user
	**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Username used to authenticate the user
	**/
	@Column(length = 50, nullable = false)
	private String username;
	
	/**
	 * Password used to authenticate the user
	**/
	@Column(columnDefinition = "char(60)", nullable = false)
	private String password;
	
	/**
	 * Indicates whether the user is enabled or disabled
	**/
	@Column(columnDefinition = "tinyint(1) default 1", nullable = false)
	private Boolean enabled;
	
	/**
	 * Authorities granted to the user
	**/
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "char(5)", nullable = false)
	private Authority authority;
	
	/**
	 * Obtaining user authority
	 * @author Thiago Pinheiro do Nascimento
	 * @since 20 mar 2025
	**/
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(authority.getName()));
	}
}