package com.great.cms.db.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author sknabil
 * @version 1.0.0
 *
 */
public interface GenericDao<T, ID extends Serializable> {

	public T findById(ID id) throws RuntimeException;

	public T findById(Class<T> entityClass , Object primaryKey) throws RuntimeException;

	public List<T> findAll() throws RuntimeException;

	public void save(T object) throws RuntimeException;

	public void update(T object) throws RuntimeException;

	public void updateNative(String sql);

	public void delete(T object) throws RuntimeException;

	public void deleteById(ID id) throws RuntimeException;

}
