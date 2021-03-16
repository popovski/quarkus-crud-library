package com.iw.labs.book.repository;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import com.iw.labs.book.domain.Book;
import com.iw.labs.book.domain.Book_;
import com.iw.labs.infrastructure.repository.BaseRepository;

@ApplicationScoped
@Transactional
public class BookRepository implements BaseRepository<Book> {
	@Inject
	EntityManager entityManager;

	@Override
	public Book findById(Long id) throws Exception {
		Book book = entityManager.find(Book.class, id);
		if (book == null) {
			throw new Exception("Entity not found");
		}

		return book;
	}
	
	@Override
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
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Book update(Book entity) {
		entityManager.merge(entity);
		entityManager.flush();
		
		return entity;
	}

	@Override
	public Book findByUuid(String uuid) throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> from = cq.from(Book.class);
		
		List<Predicate> whereClauses = new ArrayList<>();
		whereClauses.add(cb.equal(from.get(Book_.uuid), uuid));
		
		cq.where(whereClauses.stream().toArray(Predicate[]::new));
		
		TypedQuery<Book> query = this.entityManager.createQuery(cq);
		return query.getSingleResult();
	}
}
