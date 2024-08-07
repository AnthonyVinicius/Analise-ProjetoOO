package br.com.ifpe.controller;

import java.security.CryptoPrimitive;
import java.util.List;

import br.com.ifpe.entities.Cart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class ClientController extends GenericController{
    private static ClientController instance;

    private GenericDAO<Cart> cartDAO;
    private Cart cart;

    private ClientController(GenericDAO<Cart> dao) {
        super(dao);
        this.cart = new Cart();
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController((DAOFactory.createDAO(Cart.class)));
        }
        return instance;
    }

    public Cart add(CpuAbstract cpu) {
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
            // Você pode atualizar o estado do carrinho no DAO, se necessário
            // cartDAO.update(cart); // Comente/descomente conforme sua necessidade
            System.out.println("Model successfully removed from cart.");
        } else {
            System.out.println("Model not found in cart.");
        }
    }

    public List<CpuAbstract> viewAll() {
        return cart.getItems();
    }

    public double getTotalValue() {
        return cart.getTotalValue();
    }
}
