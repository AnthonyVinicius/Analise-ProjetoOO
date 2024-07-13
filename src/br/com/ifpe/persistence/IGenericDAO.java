package br.com.ifpe.persistence;

import java.util.List;

public interface IGenericDAO<T> {
	    void register(T objeto);
	    T search(T chave);
	    void delete(T chave);
	    List<T> listAll();
	}