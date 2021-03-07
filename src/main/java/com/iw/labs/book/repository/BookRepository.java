package com.iw.labs.book.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import com.iw.labs.book.domain.Book;
import com.iw.labs.infrastructure.repository.BaseRepository;

@ApplicationScoped
@Transactional
public class BookRepository implements BaseRepository<Book> {
	@Inject
	EntityManager entityManager;

	public Book findById(Long id) throws Exception {
		Book book = entityManager.find(Book.class, id);
		if (book == null) {
			throw new Exception("Entity not found");
		}

		return book;
	}

	public List<Book> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> rootEntry = cq.from(Book.class);
		CriteriaQuery<Book> all = cq.select(rootEntry);

		TypedQuery<Book> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public Book save(Book entity) {
		return entityManager.merge(entity);
	}

	@Override
	public Book merge(Book entity) {
		entityManager.persist(entity);
		
		return entity;
	}
}
