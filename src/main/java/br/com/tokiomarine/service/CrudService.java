package br.com.tokiomarine.service;

public interface CrudService<T, I> {
	Iterable<T> findAll();

	T findById(I id);

	T save(T cliente);

	String delete(long id);
}
