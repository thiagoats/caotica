package br.com.caotica.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.caotica.services.AuditingService;

/**
 * Auditing configuration class
 * @author Thiago Pinheiro do Nascimento
 * @since 24 mar 2024
**/
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditingService")
public class AuditorAwareConfig {
	
	/**
	 * Auditing provider
	 * @author Thiago Pinheiro do Nascimento
	 * @since 24 mar 2024
	**/
	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditingService();
	}
}