package br.com.caotica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caotica.models.Associate;

/**
 * Associate repository interface
 * @author Thiago Pinheiro do Nascimento
 * @since 06 mar 2025
**/
@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {

	/**
	 * Optionally find associate by cpf
	 * @author Thiago Pinheiro do Nascimento
	 * @since 13 mar 2025
	**/
	public Optional<Associate> findByCpf(String cpf);
}