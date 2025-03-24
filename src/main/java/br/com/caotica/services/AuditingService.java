package br.com.caotica.services;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Auditing service class
 * @author Thiago Pinheiro do Nascimento
 * @since 24 mar 2025
**/
@Service
public class AuditingService implements AuditorAware<String> {

	/**
	 * Loading the username of the logged in user
	 * @author Thiago Pinheiro do Nascimento
	 * @since 24 mar 2025
	**/
	@Override
	public Optional<String> getCurrentAuditor() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return Optional.of(((UserDetails) principal).getUsername());
		return Optional.of(principal.toString());
	}
}