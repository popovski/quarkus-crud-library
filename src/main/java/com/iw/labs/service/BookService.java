package com.iw.labs.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iw.labs.domain.Book;
import com.iw.labs.repository.BookRepository;

@ApplicationScoped
public class BookService {
	private static org.jboss.logging.Logger log = org.jboss.logging.Logger.getLogger(BookService.class);

	@Inject
	ObjectMapper objectMapper;

	@Inject
	BookRepository bookRepository;
	
	public Book findById(Long id) {
		log.info("Execute Book findById");
		try {
			return bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Book> findAll() {
		log.info("Execute Book findAll");
		try {
			return bookRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
