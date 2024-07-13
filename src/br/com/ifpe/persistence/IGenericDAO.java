package br.com.ifpe.persistence;

import java.util.List;

public interface IGenericDAO<T> {
	    void salvar(T objeto);
	    T buscar(T chave);
	    void remover(T chave);
	    List<T> listarTodos();
	}