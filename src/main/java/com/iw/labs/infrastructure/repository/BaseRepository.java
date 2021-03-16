package com.iw.labs.infrastructure.repository;

import java.util.List;

public interface BaseRepository<T> {
	
	public T findById(Long id) throws Exception;
	
	public T findByUuid(String uuid) throws Exception;
	
	List<T> findAll();
	
	public T save(T entity);
	
	public T update(T entity);
}
