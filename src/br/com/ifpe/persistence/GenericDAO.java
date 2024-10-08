package br.com.ifpe.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
	public void delete(T object) {
		dataBase.remove(object);
	}

	@Override
	public List<T> listAll() {
		return dataBase;
	}

	@Override
	public void update(int index, T object) {
		dataBase.set(index, object);
	}
		
}
