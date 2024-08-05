package br.com.ifpe.controler;

import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class GenericController<T>{
	private final GenericDAO<T> dao;

	public GenericController(Class<T> type) {
		this.dao = DAOFactory.createDAO(type);
	}
	

	public T search(Predicate<T> predicate) {
		return dao.search(predicate);
	}

	public void register(T entity) {
		dao.register(entity);
	}

	public void delete() {
		//fazer
	}

	public List<T> listAll(){
		return dao.listAll();
	}
}