package br.com.caotica.repositories;

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

}