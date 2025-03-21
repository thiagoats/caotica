package br.com.caotica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caotica.models.User;

/**
 * User repository interface
 * @author Thiago Pinheiro do Nascimento
 * @since 06 mar 2025
**/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Optionally find user by username
	 * @author Thiago Pinheiro do Nascimento
	 * @since 20 mar 2025
	**/
	public Optional<User> findByUsername(String username);
}