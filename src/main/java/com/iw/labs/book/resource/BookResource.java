package com.iw.labs.book.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.iw.labs.book.domain.Book;
import com.iw.labs.book.dto.BookPojo;
import com.iw.labs.book.service.BookService;

@Path("/book")
public class BookResource {
	@Inject
	BookService bookService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@GET
	@Path("{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book findBookById(@PathParam("uuid") String uuid) {
		return bookService.findByUuid(uuid);
	}

	@POST
	public BookPojo createBook(BookPojo requestBookPojo) {
		return bookService.createBook(requestBookPojo);
	}
	
	@PUT
	public BookPojo updateBook(BookPojo requestBookPojo) {
		return bookService.updateBook(requestBookPojo);
	}
}