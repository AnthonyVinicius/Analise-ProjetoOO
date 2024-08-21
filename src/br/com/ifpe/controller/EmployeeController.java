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
    protected void validateCPU(CpuAbstract object) {

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
        if(foundCpu == null || !model.equalsIgnoreCase(temp.getModel()))){
        return dao.read(foundCpu);
        }else{
            throw new RuntimeException("Error checking the cpu" + model + ". Exception: " + e.getMessage())
        }
    }

    private boolean validateCPU(String model) {
        try{
            CpuAbstract temp = search(model);
            return temp ;
        } catch (Exception e) {
            ;
        }
    }

    public void register(CpuAbstract cpu) {
        try {
            if(validateCPU(cpu.getModel())){
                genericRegister(cpu);
            }else{
                throw new RuntimeException("Model already registered in the system");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error registering" + cpu.getModel() + ". Exception: " + e.getMessage());
        }
    }

    public void delete(String model) {
        try{
            CpuAbstract cpu = search(model);
            if (cpu != null) {
                genericDelete(cpu);
            } else {
                throw new RuntimeException("CPU not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting the cpu: " + model + ". Exception: " + e.getMessage());
        }
    }

    public List<CpuAbstract> viewAll() {
       return genericListAll();
    }

    public void update(String model, CpuAbstract newCpu) {
        try{
            CpuAbstract oldCpu = search(model);
            if (oldCpu != null) {
                genericUpdate(oldCpu, newCpu);
            } else {
                throw new RuntimeException("CPU to update not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating the CPU: " + model + ". Exception" + e.getMessage());
        }

    }
}
