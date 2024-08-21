package br.com.ifpe.controller;
import java.util.List;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.utils.Logger;

public abstract class GenericController<T> {

    protected GenericDAO<T> dao;

    public GenericController(GenericDAO<T> dao) {
        this.dao = dao;
    }
    protected abstract void validateCPU(T object);

    public T genericRead(T object) {
        if (object != null) {
            Logger.info("Read " + object + "Successfully");
            return object;
        } else {
            throw new RuntimeException("Object not found in the system");
        }
    }

    public void genericRegister(T entity) {
        dao.register(entity);
        Logger.info("\nRegistered successfully!" + entity.toString());
    }

    public void genericDelete(T entity) {
        dao.delete(entity);
        Logger.info("Deleted the Cpu\n" + entity.toString());
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