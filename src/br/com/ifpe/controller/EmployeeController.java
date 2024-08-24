package br.com.ifpe.controller;

import java.util.function.Predicate;

import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class EmployeeController extends GenericController<CpuAbstract> {

    private static EmployeeController instance;

    private EmployeeController(GenericDAO<CpuAbstract> dao) {
        super(dao);
    }

    public static EmployeeController getInstance() {
        if (instance == null) {
            instance = new EmployeeController((DAOFactory.createDAO(CpuAbstract.class)));
        }
        return instance;
    }

    @Override
    protected void validateObjectIsNotNULL(CpuAbstract cpu) {
        CpuAbstract foundCpu = searchObject(cpu.getModel());
        if (foundCpu == null) {
            throw new RuntimeException("Object not found in the system");
        }
    }

    @Override
    protected void validateRegister(CpuAbstract cpu) {
        if (searchObject(cpu.getModel()) != null) {
            throw new RuntimeException("Error registering " + cpu.getModel());
        }
    }

    @Override
    protected CpuAbstract validateUpdate(CpuAbstract newCPU) {
        CpuAbstract oldCPU = searchObject(newCPU.getModel());
        if (oldCPU == null) {
            throw new RuntimeException("Object Not Found");
        }return oldCPU;
    }

    @Override
    protected CpuAbstract searchObject(String model) {
        Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equalsIgnoreCase(model);
        return dao.read(foundCpu);
    }
}
