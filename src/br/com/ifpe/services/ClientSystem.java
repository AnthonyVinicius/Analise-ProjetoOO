package br.com.ifpe.services;

import java.util.List;

import br.com.ifpe.adapter.CpfValidatorAdapter;
import br.com.ifpe.controller.EmployeeController;
import br.com.ifpe.decorator.Voucher10;
import br.com.ifpe.decorator.Voucher25;
import br.com.ifpe.entities.Cart;
import br.com.ifpe.entities.ICart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.Logger;


public class ClientSystem {
    private final EmployeeController employeeController = EmployeeController.getInstance();
    CpfValidatorAdapter adapter = new CpfValidatorAdapter();
    private static ClientSystem instance;
    private ICart cart = new Cart();

    private ClientSystem() {
        super();
    }

    public static ClientSystem getInstance() {
        if (instance == null) {
            instance = new ClientSystem();
        }
        return instance;
    }

    public void validateCPF(String cpf) {
        if (!adapter.validateCPF(cpf)) {
            throw new RuntimeException("Invalid CPF");
        }
    }

    private double addVoucher10() {
        cart = new Voucher10(cart);
        return cart.getPrice();
    }

    private double addVoucher25() {
        cart = new Voucher25(cart);
        return cart.getPrice();
    }

    public double applyDiscount(int voucher) {
        if (voucher == 1) {
            return addVoucher10();
        } else if (voucher == 2) {
            return addVoucher25();
        } else {
            throw new RuntimeException("Invalid Voucher");
        }
    }

    public double finalizePurchase(String cpf, double totalValue) {
        try {
            Logger.info("Purchase finalized\nCPF: " + cpf + "\nTotal Value: R$" + totalValue);
            cart = new Cart();
            return totalValue;
        } catch (Exception e) {
            Logger.error("Error finalizing the purchase. Exception: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addItemToCart(String model) {
        CpuAbstract cpu = employeeController.genericRead(model);
        if (cpu == null) {
            String text = "Model not found";
            Logger.error(text);
            throw new RuntimeException(text);
        } else {
            Logger.info("Cpu added to cart" + cpu);
            cart.add(cpu);
        }
    }

    public void deleteItemFromCart(String model) {
        CpuAbstract toRemove = cart.getItems()
                .stream()
                .filter(cpu -> cpu.getModel().equalsIgnoreCase(model))
                .findFirst()
                .orElseThrow(() -> {
                    String text = "Model " + model + " not found in cart" ;
                    Logger.error(text);
                    return new RuntimeException(text);
                });
        cart.remove(toRemove);
        Logger.info("Model " + model + " removed from the cart");
    }

    public List<CpuAbstract> viewAllItemsCart() {
        return cart.getItems();
    }

    public double getTotalValue() {
        Logger.info("Get Total Cart Price");
        return cart.getPrice();
    }
}


