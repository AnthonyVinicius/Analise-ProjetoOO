package br.com.ifpe.controller;

import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;

public abstract class GenericController<T> {

    protected GenericDAO<T> dao;

    public GenericController(GenericDAO<T> dao) {
        this.dao = dao;
    }

    public T genericRead(T object) {
        if (object != null) {
            return object;
        } else {
            throw new RuntimeException("Object not found in the system");
        }
    }

    public void genericRegister(T entity) {
        dao.register(entity);
    }

    public void genericDelete(T entity) {
        dao.delete(entity);
    }

    public List<T> generciListAll() {
        return dao.listAll();
    }
}