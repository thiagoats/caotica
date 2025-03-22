package br.com.caotica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.caotica.models.User;
import br.com.caotica.repositories.UserRepository;

/**
 * Authentication service class
 * @author Thiago Pinheiro do Nascimento
 * @since 20 mar 2025
**/
@Service
public class AppUserDetailsService implements UserDetailsService {

	/**
	 * Dependency injection with the user repository interface
	**/
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Locates the user based on the username
	 * @author Thiago Pinheiro do Nascimento
	 * @since 20 mar 2025
	**/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não existe"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
	}
}