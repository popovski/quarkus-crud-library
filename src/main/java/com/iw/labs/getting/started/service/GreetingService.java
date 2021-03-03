package com.iw.labs.getting.started.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class GreetingService {
	private static org.jboss.logging.Logger log = org.jboss.logging.Logger.getLogger(GreetingService.class);

	@Inject
	ObjectMapper objectMapper;

	@Inject
	EntityManager em;

	public String greeting() {
		log.info("Execute Greeting");

		return "hello from service";
	}
}
