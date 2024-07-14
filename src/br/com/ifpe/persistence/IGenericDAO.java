package br.com.ifpe.persistence;

import java.util.List;

public interface IGenericDAO<T> {
	    void register(T object);
	    T search(String chave);
	    void delete(String chave);
	    List<T> listAll();
	}