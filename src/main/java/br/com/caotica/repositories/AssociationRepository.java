package br.com.caotica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caotica.models.Association;

/**
 * Association repository interface
 * @author Thiago Pinheiro do Nascimento
 * @since 06 mar 2025
**/
@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

}