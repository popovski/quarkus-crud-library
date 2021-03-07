package com.iw.labs.infrastructure.repository;

public interface BaseRepository<T> {
	
	public T findById(Long id) throws Exception;
	
	public T save(T entity);
	
	public T merge(T entity);
}
