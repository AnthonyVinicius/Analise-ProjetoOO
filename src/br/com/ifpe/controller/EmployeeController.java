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

    public CpuAbstract search(String model) {
        Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equalsIgnoreCase(model);
        return dao.read(foundCpu);
    }

    private boolean alreadyRegister(String model) {
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

    public void update(String model, CpuAbstract newCpu) {
        CpuAbstract oldCpu = search(model);
        if (oldCpu != null) {
            genericUpdate(oldCpu, newCpu);
        } else {
            throw new RuntimeException("CPU to update not found.");
        }
    }
}
