package br.com.ifpe.controller;

import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class EmployeeController extends GenericController<CpuAbstract> {

    private static EmployeeController instance;

    private EmployeeController(GenericDAO<CpuAbstract> dao) {
        super(dao);
    }

    @Override
    protected void validateCPU(CpuAbstract entity) {

    }

    public static EmployeeController getInstance() {
        if (instance == null) {
            instance = new EmployeeController((DAOFactory.createDAO(CpuAbstract.class)));
        }
        return instance;
    }

    public CpuAbstract read(String model) {
        return genericRead(search(model));
    }

    public CpuAbstract search(String model) {
        Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equalsIgnoreCase(model);
        return dao.read(foundCpu);
    }

    public void register(CpuAbstract cpu) {
        try {
            if (search(cpu.getModel()) == null) {
                genericRegister(cpu);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error registering " + cpu.getModel() + e.getMessage());
        }
    }

    public void delete(String model) {
        genericDelete(search(model));
    }

    public List<CpuAbstract> viewAll() {
        return genericListAll();
    }

    public void update(String model, CpuAbstract newCpu) {
        try {
            CpuAbstract oldCpu = search(model);
            genericUpdate(oldCpu, newCpu);
        } catch (Exception e) {
            throw new RuntimeException("Error when updating  " + e.getMessage());
        }
    }
}
