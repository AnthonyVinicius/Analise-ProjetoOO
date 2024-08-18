package br.com.ifpe.controller;

import java.util.List;

import br.com.ifpe.adapter.CpfValidatorAdapter;
import br.com.ifpe.decorator.Cupom10;
import br.com.ifpe.decorator.Cupom25;
import br.com.ifpe.entities.Cart;
import br.com.ifpe.entities.ICart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.utils.Logger;

public class ClientController {
    private final EmployeeController employeeController = EmployeeController.getInstance();
    CpfValidatorAdapter adapter = new CpfValidatorAdapter();
    private static ClientController instance;
    private final ICart cart = new Cart();

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    private double addCupom10() {
        ICart cartCupom10 = new Cupom10(cart);
        return cartCupom10.getPrice();
    }

    private double addCupom25() {
        ICart cartCupom25 = new Cupom25(cart);
        return cartCupom25.getPrice();
    }

    public void validateCPF(String cpf) {
        if (!adapter.validateCPF(cpf)) {
            throw new RuntimeException("Invalid CPF");
        }
    }

    public double finalizePurchase(String cpf, int cupom) {
        validateCPF(cpf);

        try {
            double totalValue = applyDiscount(cupom);
            Logger.info("Purchase finalized with the CPF: " + cpf + ". Total Value: R$" + totalValue);
            return totalValue;
        } catch (Exception e) {
            Logger.error("Error finalizing the purchase. Exception: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public double applyDiscount(int cupom) {
        if (cupom == 1) {
            return addCupom10();
        } else if (cupom == 2) {
            return addCupom25();
        } else {
            throw new RuntimeException("Invalid cupom");
        }
    }


    public void add(String model) {
        CpuAbstract cpu = employeeController.search(model);
        if (cpu != null) {
            cart.add(cpu);
        } else {
           throw new RuntimeException("Model not found");
        }
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
            Logger.info("Model " + model + " removed from the cart");
        } else {
            String text = "Model" + model + " not found in cart";
            Logger.error(text);
            throw new RuntimeException(text);
        }
    }

    public List<CpuAbstract> viewAllCpus() {
        return employeeController.viewAll();
    }

    public List<CpuAbstract> viewAllItemsCart() {
        return cart.getItems();
    }

    public double getTotalValue() {
        return cart.getPrice();
    }
}
