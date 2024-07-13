package br.com.ifpe.persistence;

import java.util.ArrayList;
import java.util.List;

public class CpuDAO<T> implements IGenericDAO<T> {
    
    private List<T> dataStore;  

    public CpuDAO() {
        this.dataStore = new ArrayList<>();
    }

    @Override
    public void salvar(T objeto) {
        dataStore.add(objeto);
    }

    @Override
    public T buscar(T chave) {
        for (T objeto : dataStore) {
            if (objeto.equals(chave)) {
                return objeto;
            }
        }
        return null;  
    }

    @Override
    public void remover(T chave) {
        dataStore.remove(chave);
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(dataStore);
    }
}