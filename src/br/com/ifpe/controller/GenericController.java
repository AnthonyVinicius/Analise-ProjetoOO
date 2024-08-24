package br.com.ifpe.controller;

import java.util.List;

import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.persistence.Logger;

public abstract class GenericController<T> {

    protected GenericDAO<T> dao;

    public GenericController(GenericDAO<T> dao) {
        this.dao = dao;
    }

    protected abstract void validateObjectIsNotNULL(T object);

    protected abstract void validateRegister(T object);

    protected abstract void validateUpdate(T object);

    protected abstract T searchObject(String object);

    public T genericRead(String object) {
        try {
            T foundObject = this.searchObject(object);
            this.validateObjectIsNotNULL(foundObject);
            Logger.info("Read " + foundObject.toString() + " Successfully");
            return foundObject;
        } catch (Exception e) {
            String text = "Object Not Found";
            Logger.error(text);
            throw new RuntimeException(text);
        }
    }

    public void genericRegister(T object) {
        this.validateRegister(object);
        Logger.info("Registered successfully!" + object.toString());
        dao.register(object);
    }

    public void genericDelete(String object) {
        try{

        T foundObject = this.searchObject(object);
        this.validateObjectIsNotNULL(foundObject);
        Logger.info("Deleted from the system\n" + foundObject.toString());
        dao.delete(foundObject);
        }catch (Exception e){
            String text = "Object Not Found";
            Logger.error(text);
            throw new RuntimeException(text);
        }
    }

    public List<T> genericListAll() {
        Logger.info("List All Objects");
        return dao.listAll();
    }

    public void genericUpdate(T object) {
        this.validateUpdate(object);
        int index = genericListAll().indexOf(object);
        try {
            Logger.info("Updating entity: " + dao.listAll().get(index).toString() + " -> " + object.toString());
            dao.update(index, object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}