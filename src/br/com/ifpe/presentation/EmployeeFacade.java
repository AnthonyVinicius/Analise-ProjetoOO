package br.com.ifpe.presentation;

import java.util.List;
import br.com.ifpe.controller.EmployeeController;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class EmployeeFacade {
    private final EmployeeController controller = EmployeeController.getInstance();

    public void register(CpuAbstract cpu) {
        controller.register(cpu);
    }

    public CpuAbstract search(String model) {
        return controller.search(model);
    }

    public void delete(String model) {
        controller.delete(model);
    }

    public boolean alreadyRegister(String model) {
        return controller.alreadyRegister(model);
    }

    public List<CpuAbstract> viewAll() {
        return controller.viewAll();
    }
}
