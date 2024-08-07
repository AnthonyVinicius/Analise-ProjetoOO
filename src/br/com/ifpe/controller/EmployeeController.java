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

    public static EmployeeController getInstance() {
        if (instance == null) {
            instance = new EmployeeController((DAOFactory.createDAO(CpuAbstract.class)));
        }
        return instance;
    }

    public CpuAbstract read(String model) {
        return genericRead(search(model));
    }

    private CpuAbstract search(String model) {
        Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equalsIgnoreCase(model);
        return dao.read(foundCpu);
    }

    public boolean alreadyRegister(String model) {
        CpuAbstract temp = search(model);
        if (temp != null && model.equalsIgnoreCase(temp.getModel())) {
            return false;
        } else {
            return true;
        }
    }

    public void register(CpuAbstract cpu) {
        if(alreadyRegister(cpu.getModel())){
        genericRegister(cpu);
        }else{
            throw new RuntimeException("Model already registered in the system");
        }
    }

    public void delete(String model) {
        CpuAbstract cpu = search(model);
        if (cpu != null) {
            genericDelete(cpu);
        } else {
            throw new RuntimeException("CPU not found.");
        }
    }

    public List<CpuAbstract> viewAll() {
       return generciListAll();
    }
}
