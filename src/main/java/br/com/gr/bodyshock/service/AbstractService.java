package br.com.gr.bodyshock.service;

import java.util.List;

public interface AbstractService<T, ID> {
	void save(T arg);

	void update(T arg);

	T findById(ID id);

	List<T> findAll();
	
	void delete(T arg);

}
