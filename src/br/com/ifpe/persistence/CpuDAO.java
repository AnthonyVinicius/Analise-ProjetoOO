package br.com.ifpe.persistence;

import java.util.ArrayList;
import java.util.List;
import br.com.ifpe.entities.abtract.CpuAbstract;

public class CpuDAO<T extends CpuAbstract> implements IGenericDAO<T> {
    
    private List<T> dataStore;  

    public CpuDAO() {
        this.dataStore = new ArrayList<>();
    }

    @Override
    public void register(T object) {
        dataStore.add(object);
    }

    public T search(String model) {
        for (T object : dataStore) {
            if (object.getmodel().equalsIgnoreCase(model)) {
                return object;
            }
        }
        return null;  
    }

    public void delete(String model) {
        dataStore.removeIf(object -> object.getmodel().equalsIgnoreCase(model));
    }

    @Override
    public List<T> listAll() {
        return new ArrayList<>(dataStore);
    }
}
