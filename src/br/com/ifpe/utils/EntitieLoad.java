package br.com.ifpe.utils;

import br.com.ifpe.controller.EmployeeController;
import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.AmdCpu;
import br.com.ifpe.entities.AmdCpuBuilder;

public class EntitieLoad {
    public void loadEntities() {
        EmployeeController employeeController = EmployeeController.getInstance();

        IntelCpu i33710 = new IntelCpuBuilder()
                .model("i33710")
                .socket("LGA 775")
                .core(6)
                .threads(12)
                .hrz(3.4)
                .price(100)
                .build();

        IntelCpu i53600 = new IntelCpuBuilder()
                .model("i53600")
                .socket("LGA 775")
                .core(6)
                .threads(12)
                .hrz(3.4)
                .price(150)
                .build();

        AmdCpu r55600 = new AmdCpuBuilder()
                .model("r55600")
                .socket("AM4")
                .core(6)
                .threads(12)
                .hrz(4.6)
                .price(130)
                .build();

        AmdCpu r97600 = new AmdCpuBuilder()
                .model("r97600")
                .socket("AM4")
                .core(6)
                .threads(12)
                .hrz(4.6)
                .price(180)
                .build();

        employeeController.register(i33710);
        employeeController.register(i53600);
        employeeController.register(r55600);
        employeeController.register(r97600);
    }
}
