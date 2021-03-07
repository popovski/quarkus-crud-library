package com.iw.labs.book.mapper;

import com.iw.labs.book.domain.Book;
import com.iw.labs.book.dto.BookPojo;
import com.iw.labs.infrastructure.mapper.GeneralMapper;

public interface BookMapper extends GeneralMapper<BookPojo, Book> {
	public void mapRequestedFieldForUpdate(Book entity, BookPojo dto);
}
