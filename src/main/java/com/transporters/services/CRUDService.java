package com.transporters.services;

import java.util.List;

public interface CRUDService<T> {

	List<?> listAll();

	T getById(Integer id);

	T save(T domainObject);

	T update(T domainObject);

	boolean delete(Integer id);
}
