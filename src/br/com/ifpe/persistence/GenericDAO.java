package br.com.ifpe.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.entities.abtract.CpuAbstract;

public class GenericDAO<T> implements IGenericDAO<T> {

	private List<T> dataBase = new ArrayList<T>();  

	public GenericDAO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void register(T object) {
		dataBase.add(object);
	}

	@Override
	public T search(Predicate<T> filter) {
		return dataBase.stream().filter(filter).findFirst().orElse(null);    			
	}

	@Override
	public boolean delete(T object) {
		return dataBase.remove(object);
	}

	@Override
	public List<T> listAll() {
		return dataBase;
	}
}
