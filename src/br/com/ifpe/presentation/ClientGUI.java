package br.com.ifpe.presentation;

import br.com.ifpe.entities.IntelCpu;

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

    public void finalizePurchase() {
        System.out.println("Enter your CPF");
        String cpf = scanner.nextLine();
        System.out.println("Choice Discount Cupom:\n[1]-10%\n[2]-25%");
        int cupom = Integer.parseInt(scanner.nextLine());
        System.out.println("R$" + facade.clientFinalizePurchase(cpf,cupom));
    }
}
