package com.iw.labs.book.mapper.impl;

import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;
import com.iw.labs.book.domain.Book;
import com.iw.labs.book.dto.BookPojo;
import com.iw.labs.book.mapper.BookMapper;
import com.iw.labs.infrastructure.mapper.AbstractGeneralMapper;

@ApplicationScoped
public class BookMapperImpl extends AbstractGeneralMapper implements BookMapper {
	
	public BookMapperImpl() {
		super(new ModelMapper());
	}

	@Override
	public BookPojo entityToDto (Book book) {		
		return this.modelMapper.map(book, BookPojo.class);
	}
	
	@Override
	public Book dtoToEntity(BookPojo bookDto) {		
		return this.modelMapper.map(bookDto, Book.class);	
	}
	
	public void mapRequestedFieldForUpdate(Book entity, BookPojo dto) {
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setModifiedOn(new Date());
	}
}