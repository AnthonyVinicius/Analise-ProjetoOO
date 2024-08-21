package br.com.ifpe.presentation;

import br.com.ifpe.utils.Logger;

import java.util.Scanner;

public class ClientGUI {
    Scanner scanner = new Scanner(System.in);

    public void gui() {
        boolean running = true;
        while (running) {
            try {
                System.out.println("===========================================");
                System.out.println("[1]-Add\n[2]-Delete\n[3]-View all CPUS\n[4]-View all Items Cart\n[5]-Finalize Purchase\n[6]-Back");
                System.out.println("===========================================");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        add();
                        break;
                    case "2":
                        delete();
                        break;
                    case "3":
                        viewAllCpus();
                        break;
                    case "4":
                        viewAllItemsCart();
                        break;
                    case "5":
                        finalizePurchase();
                        break;
                    case "6":
                        running = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid Code: " + e.getMessage());
                Logger.error(e.getMessage());
            }
        }
    }

    Facade facade = new Facade();

    public void add() {
        System.out.println("Enter the model you want to add");
        String model = scanner.nextLine();
        facade.clientAdd(model);
        System.out.println("CPU added to cart");
    }

    public void delete() {
        System.out.println("Enter the model you want to delete");
        String model = scanner.nextLine();
        facade.clientDelete(model);
        System.out.println("Model successfully removed from cart.");
    }

    public void viewAllCpus() {
        System.out.println(facade.clientViewAllCpus().toString());
    }

    public void viewAllItemsCart() {
        System.out.println(facade.clientViewAllItemsCart().toString());
        System.out.println("R$" + facade.clientTotalPrice());
    }

    private double discount() {
        System.out.println("Choice Discount Voucher:\n[1]-10%\n[2]-25%");
        int voucher = Integer.parseInt(scanner.nextLine());
        return facade.clientApplyDiscount(voucher);
    }

    public void finalizePurchase() {
        double totalValue;
        boolean on_off = true;
        System.out.println("Enter your CPF: ");
        String cpf = scanner.nextLine();
        facade.clientValidateCPF(cpf);
        totalValue = discount();
        while (on_off) {
            System.out.println("Would you like to add any more voucher?:\n[1]-Yes\n[2]-No");
            String option = scanner.nextLine().toLowerCase();
            switch (option) {
                case ("1"):
                    totalValue = discount();
                    break;
                case ("2"):
                    System.out.println("================================================");
                    System.out.println("|CPF: "+ cpf);
                    System.out.println("|Total: R$" + facade.clientFinalizePurchase(cpf, totalValue));
                    System.out.println("================================================");
                    on_off = false;
                    break;
                default:
                    System.out.println("Invalid Code");
            }
        }
    }
}

