package br.com.ifpe.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CpuDAO<T> implements IGenericDAO<T> {
    
    private List<T> dataStore;  

    public CpuDAO() {
        this.dataStore = new ArrayList<>();
    }

    @Override
    public void register(T objeto) {
        dataStore.add(objeto);
    }

    @Override
    public T search(T chave) {
    	for (T objeto : dataStore) {
    		if (objeto.equals(chave)) {
                return objeto;
            }
        }
        return null;  
    }

    @Override
    public void delete(T chave) {
        dataStore.remove(chave);
    }

    @Override
    public List<T> listAll() {
        return dataStore.stream().collect(Collectors.toList());
    }
}