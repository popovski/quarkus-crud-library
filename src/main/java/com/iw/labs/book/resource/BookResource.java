package com.iw.labs.book.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.iw.labs.book.domain.Book;
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
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book findBookById(@PathParam("id") Long id) {
		return bookService.findById(id);
	}


}
