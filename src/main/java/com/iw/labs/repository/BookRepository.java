package com.iw.labs.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.iw.labs.domain.Book;

@ApplicationScoped
public class BookRepository {
	@Inject
	EntityManager em;
	
	public Book findById(Long id) throws Exception {
		Book book = em.find(Book.class, id);
		if (book == null) {
			throw new Exception("Entity not found");
		}
		
		return book;
	}
	
	public List<Book> findAll() {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Book> cq = cb.createQuery(Book.class);
	    Root<Book> rootEntry = cq.from(Book.class);
	    CriteriaQuery<Book> all = cq.select(rootEntry);

	    TypedQuery<Book> allQuery = em.createQuery(all);
	    return allQuery.getResultList();
  }
}
