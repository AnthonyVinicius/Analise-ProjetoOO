package br.com.ifpe.controller;

import java.util.List;

import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.utils.Logger;

public abstract class GenericController<T> {

    protected GenericDAO<T> dao;

    public GenericController(GenericDAO<T> dao) {
        this.dao = dao;
    }

    protected abstract void validateCPU(T entity);

    public T genericRead(T object) {
        if (object == null) {
            throw new RuntimeException("Object not found in the system");
        }
        Logger.info("Read " + object + " Successfully");
        return object;
    }

    public void genericRegister(T entity) {
        Logger.info("\nRegistered successfully! " + entity);
        dao.register(entity);
    }

    public void genericDelete(T entity) {
        if (entity == null) {
            throw new RuntimeException("Object not found in the system");
        }
        Logger.info("Deleted the Cpu\n" + entity.toString());
        dao.delete(entity);
    }

    public List<T> genericListAll() {
        Logger.info("List All Objects");
        return dao.listAll();
    }

    public void genericUpdate(T oldObject, T newObject) {
        if (!dao.update(oldObject, newObject)) {
            throw new RuntimeException("Object to be updated not found.");
        }
        Logger.info("Updated the CPU " + oldObject + " successfully");
    }
}