package br.com.caotica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caotica.exceptions.EntityInUseException;
import br.com.caotica.exceptions.EntityNotFoundException;
import br.com.caotica.models.Associate;
import br.com.caotica.repositories.AssociateRepository;

/**
 * Associate service class
 * @author Thiago Pinheiro do Nascimento
 * @since 06 mar 2025
**/
@Service
public class AssociateService {
	
	/**
	 * Dependency injection with the associate repository interface
	**/
	@Autowired
	private AssociateRepository associateRepository;
	
	/**
	 * Associate persistence method
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@Transactional
	public Associate persist(Associate associate) {
		 return associateRepository.save(associate);
	}
	
	/**
	 * Associate capture method
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	public Associate findOrFail(Long id) {
		return associateRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Associado %d não encontrado", id)));
	}
	
	/**
	 * Associate deletion method
	 * @author Thiago Pinheiro do Nascimento
	 * @since 06 mar 2025
	**/
	@Transactional
	public void remove(Associate associate) {
		try {
			associateRepository.deleteById(associate.getId());
			associateRepository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Associado %d em uso", associate.getId()));
		}
	}
}