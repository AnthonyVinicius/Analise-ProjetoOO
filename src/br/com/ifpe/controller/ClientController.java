package br.com.ifpe.controller;
import java.util.List;

import br.com.ifpe.adapter.CpfValidatorAdapter;
import br.com.ifpe.entities.Cart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.utils.Logger;

public class ClientController{
    private static ClientController instance;
    private final EmployeeController employeeController = EmployeeController.getInstance();
    CpfValidatorAdapter adapter = new CpfValidatorAdapter();
    private final Cart cart;

    private ClientController() {
        this.cart = new Cart();
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }
//    public void addCoupon(String couponType) {
//        if (couponType.equals("client")) {
//            cupom = new CupomClientDecorator(cupom);
//        } else if (couponType.equals("employee")) {
//            cupom = new CupomEmployeeDecorator(cupom);
//        }
//    }

    public void finalizePurchase(String cpf) {
        try{
            adapter.validateCPF(cpf);
            double totalValue = applyDiscount();
            Logger.info("Purchase finalized with the cpf: " + cpf + "Total Value: " + totalValue);
            System.out.println("Total value after discount: " + totalValue);
        } catch (Exception e) {
            Logger.error("Error finalizing the purchase. Exception: " + e.getMessage());
            throw new RuntimeException("Error");
        }
    }
    private double applyDiscount() {
        return getTotalValue();
    }


    public void add(String model) {
    CpuAbstract cpu = employeeController.search(model);
        cart.add(cpu);
    }

    public void delete(String model) {
        List<CpuAbstract> items = cart.getItems();
        CpuAbstract toRemove = null;
        for (CpuAbstract cpu : items) {
            if (cpu.getModel().equalsIgnoreCase(model)) {
                toRemove = cpu;
                break;
            }
        }
        if (toRemove != null) {
            cart.remove(toRemove);
            System.out.println("Model successfully removed from cart.");
            Logger.info("Model " + model + "removed from the cart");
        } else {
            Logger.error("Model" + model + "not found in cart");
            System.out.println("Model not found in cart.");
        }
    }

    public List<CpuAbstract> viewAllCpus() {
        return employeeController.viewAll();
    }

    public List<CpuAbstract> viewAllItemsCart() {
        return cart.getItems();
    }

    public double getTotalValue() {
        return cart.getTotalValue();
    }
}
