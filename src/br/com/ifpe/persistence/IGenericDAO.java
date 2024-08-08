package br.com.ifpe.persistence;

import java.util.List;
import java.util.function.Predicate;

public interface IGenericDAO<T> {
	    void register(T object);
	    boolean delete(T object);
	    List<T> listAll();
		T read(Predicate<T> filter);
		boolean update(T oldObject, T newObject);
	}