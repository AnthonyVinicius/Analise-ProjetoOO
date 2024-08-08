package br.com.ifpe.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class GenericDAO<T> implements IGenericDAO<T> {

	private List<T> dataBase;

	public GenericDAO() {
		this.dataBase = new ArrayList<T>();
	}

	@Override
	public void register(T object) {
		dataBase.add(object);
	}

	@Override
	public T read(Predicate<T> filter) {
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

	@Override
	public boolean update(T oldObject, T newObject) {
		int index = dataBase.indexOf(oldObject);
		if (index >= 0) {
			dataBase.set(index, newObject);
			return true;
		}
		return false;
	}
		
}
