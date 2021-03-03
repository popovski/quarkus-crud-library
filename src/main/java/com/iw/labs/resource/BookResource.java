package com.iw.labs.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.iw.labs.domain.Book;
import com.iw.labs.service.BookService;

@Path("/book")
public class BookResource {
	@Inject
	BookService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> findAll() {
		return service.findAll();
	}
		
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book findBookById(@PathParam("id") Long id) {
		return service.findById(id);
	}
	
	
}
