package br.com.ifpe.controller;
import java.util.List;
import br.com.ifpe.adapter.CpfValidatorAdapter;
import br.com.ifpe.decorator.Voucher10;
import br.com.ifpe.decorator.Voucher25;
import br.com.ifpe.entities.Cart;
import br.com.ifpe.entities.ICart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;
import br.com.ifpe.utils.Logger;


public class ClientController extends GenericController<ICart> {
    private final EmployeeController employeeController = EmployeeController.getInstance();
    CpfValidatorAdapter adapter = new CpfValidatorAdapter();
    private static ClientController instance;
    private ICart cart = new Cart();

    private ClientController(GenericDAO<ICart> dao) {
        super(dao);
    }

    @Override
    protected void validateCPU(ICart entity) {

    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController(DAOFactory.createDAO(ICart.class));
        }
        return instance;
    }


    public void validateCPF(String cpf) {
        if (!adapter.validateCPF(cpf)) {
            throw new RuntimeException("Invalid CPF");
        }
    }

    public double finalizePurchase(String cpf, double totalValue) {
        try {
            Logger.info("Purchase finalized with the CPF: " + cpf + ". Total Value: R$" + totalValue);
            addCartHistory(cart);
            cart = new Cart();
            return totalValue;
        } catch (Exception e) {
            Logger.error("Error finalizing the purchase. Exception: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
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
    public void add(String model) {
        CpuAbstract cpu = employeeController.search(model);
        if (cpu != null) {
            Logger.info(cpu + " cpu added to cart");
            cart.add(cpu);
        } else {
            String text = "Model not found";
            Logger.error(text);
            throw new RuntimeException(text);
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
            String text = "Model " + model + " not found in cart";
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
        Logger.info("Get Total Cart Price");
        return cart.getPrice();
    }
    private void addCartHistory(ICart cart){
        genericRegister(cart);
    }
    public List<ICart> viewHistory(){
        return genericListAll();
    }

   public void clearHistory(){
      genericDelete();
   }
}
