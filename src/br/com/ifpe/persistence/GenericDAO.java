package br.com.ifpe.persistence;

import java.util.List;

public interface GenericDAO<T, K> {
	    void salvar(T objeto);
	    T buscar(K chave);
	    void remover(K chave);
	    List<T> listarTodos();
	}