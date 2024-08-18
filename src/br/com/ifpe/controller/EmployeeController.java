package br.com.ifpe.controller;
import java.util.List;
import java.util.function.Predicate;

import br.com.ifpe.entities.AmdCpu;
import br.com.ifpe.entities.AmdCpuBuilder;
import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;
import br.com.ifpe.utils.Logger;

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
        try{
            CpuAbstract temp = search(model);
            return temp == null || !model.equalsIgnoreCase(temp.getModel());
        } catch (Exception e) {
            Logger.error("Error checking the cpu" + model + ". Exception: " + e.getMessage());
            throw new RuntimeException("Error");
        }
    }

    public void register(CpuAbstract cpu) {
        try {
            if(alreadyRegister(cpu.getModel())){
                genericRegister(cpu);
                Logger.info("Cpu" + cpu.getModel() +" registered successfully!");
            }else{
                throw new RuntimeException("Model already registered in the system");
            }
        } catch (Exception e) {
            Logger.error("Error registering" + cpu.getModel() + ". Exception: " + e.getMessage());
            throw new RuntimeException("Error");
        }
    }

    public void delete(String model) {
        try{
            CpuAbstract cpu = search(model);
            if (cpu != null) {
                genericDelete(cpu);
                Logger.info("Deleted the Cpu " + model +  "Successfully");
            } else {
                throw new RuntimeException("CPU not found.");
            }
        } catch (Exception e) {
            Logger.error("Error deleting the cpu: " + model + ". Exception: " + e.getMessage());
            throw new RuntimeException("Error");
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
                Logger.info("Updated the CPU" + model + "successfully");
            } else {
                throw new RuntimeException("CPU to update not found.");
            }
        } catch (Exception e) {
            Logger.error("Error updating the CPU: " + model + ". Exception" + e.getMessage());
            throw new RuntimeException("Error");
        }

    }
        public AmdCpu createAMD(String model, String socket, int core, int threads, double hrz, double price) {
            return new AmdCpuBuilder()
                    .model(model)
                    .socket(socket)
                    .core(core)
                    .threads(threads)
                    .hrz(hrz)
                    .price(price)
                    .build();
        }

    public IntelCpu createIntel(String model, String socket, int core, int threads, double hrz, double price) {
        return new IntelCpuBuilder()
                .model(model)
                .socket(socket)
                .core(core)
                .threads(threads)
                .hrz(hrz)
                .price(price)
                .build();
    }
}
