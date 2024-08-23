package br.com.ifpe.presentation;

import java.util.List;

import br.com.ifpe.controller.EmployeeController;
import br.com.ifpe.services.ClientSystem;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class Facade {
    private final EmployeeController employeeController = EmployeeController.getInstance();
    private final ClientSystem clientController = ClientSystem.getInstance();

    public void employeeRegister(CpuAbstract cpu) {employeeController.genericRegister(cpu);}

    public void employeeDelete(String model) {employeeController.genericDelete(model);}

    public List<CpuAbstract> employeeViewAll() {return employeeController.genericListAll();}

    public void employeeUpdate(CpuAbstract updatedCpu) {employeeController.genericUpdate(updatedCpu);}

    public CpuAbstract employeeRead(String model) {return employeeController.genericRead(model);}

    public void clientAdd(String model) {clientController.addItemToCart(model);}

    public void clientDelete(String model) {clientController.deleteItemFromCart(model);}

    public double clientFinalizePurchase(String cpf, double totalValue) {return clientController.finalizePurchase(cpf, totalValue);}

    public double clientTotalPrice() {return clientController.getTotalValue();}

    public List<CpuAbstract> clientViewAllCpus() {return employeeController.genericListAll();}

    public List<CpuAbstract> clientViewAllItemsCart() {return clientController.viewAllItemsCart();}

    public double clientApplyDiscount(int option){return clientController.applyDiscount(option);}

    public void clientValidateCPF(String cpf){clientController.validateCPF(cpf);}

}
