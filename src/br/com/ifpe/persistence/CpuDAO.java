package br.com.ifpe.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ifpe.entities.abtract.CpuAbstract;

public class CpuDAO<T extends CpuAbstract> implements IGenericDAO<T> {
    
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
    public void delete(String chave) {
    dataStore.removeIf(model -> model.getModelo().equalsIgnoreCase(model.getModelo()));
    }

    @Override
    public List<T> listAll() {
        return dataStore.stream().collect(Collectors.toList());
    }
}