package br.com.ifpe.presentation;

import java.util.List;

import br.com.ifpe.controller.EmployeeController;
import br.com.ifpe.controller.ClientController;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class Facade {
    private final EmployeeController employeeController = EmployeeController.getInstance();
    private final ClientController clientController = ClientController.getInstance();

    public void employeeRegister(CpuAbstract cpu) {
        employeeController.register(cpu);
    }

    public CpuAbstract employeeRead(String model) {
        return employeeController.read(model);
    }

    public void employeeDelete(String model) {
        employeeController.delete(model);
    }

    public void employeeUpdate(String oldModel, CpuAbstract updatedCpu) {
        employeeController.update(oldModel, updatedCpu);
    }

    public List<CpuAbstract> employeeViewAll() {
        return employeeController.viewAll();
    }

    public void clientAdd(String model) {
        clientController.add(model);
    }

    public void clientDelete(String model) {
        clientController.delete(model);
    }

    public double clientFinalizePurchase(String cpf, int cupom) {
        return clientController.finalizePurchase(cpf, cupom);
    }

    public double clientTotalPrice() {
        return clientController.getTotalValue();
    }

    public List<CpuAbstract> clientViewAllCpus() {
        return clientController.viewAllCpus();
    }

    public List<CpuAbstract> clientViewAllItemsCart() {
        return clientController.viewAllItemsCart();
    }


}
