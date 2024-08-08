package br.com.ifpe.controller;
import java.util.List;
import br.com.ifpe.entities.Cart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class ClientController{
    private static ClientController instance;
    private EmployeeController employeeController = EmployeeController.getInstance();
    private Cart cart;

    private ClientController() {
        this.cart = new Cart();
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Cart add(String model) {
    CpuAbstract cpu = employeeController.search(model);
        cart.add(cpu);
        return cart;
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
        } else {
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
