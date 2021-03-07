package com.iw.labs.book.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iw.labs.book.domain.Book;
import com.iw.labs.book.dto.BookPojo;
import com.iw.labs.book.mapper.impl.BookMapperImpl;
import com.iw.labs.book.repository.BookRepository;

@ApplicationScoped
public class BookService {
	private static org.jboss.logging.Logger log = org.jboss.logging.Logger.getLogger(BookService.class);

	@Inject
	ObjectMapper objectMapper;

	@Inject
	BookRepository bookRepository;

	@Inject
	BookMapperImpl bookMapper;
	
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

	public BookPojo createBook(BookPojo bookPojo) {
		log.debug("Execute createBook with parameters");
		
		Book transientBook = bookMapper.dtoToEntity(bookPojo);
		Book persistedBook = bookRepository.save(transientBook);

		return bookMapper.entityToDto(persistedBook);
	}

}
