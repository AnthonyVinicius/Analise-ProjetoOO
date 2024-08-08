package br.com.ifpe.presentation;

import br.com.ifpe.entities.Cart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

import java.util.List;
import java.util.Scanner;

public class ClientGUI {
    Scanner scanner = new Scanner(System.in);

    public void gui() {
        boolean running = true;
        while (running) {
            try {

                System.out.println("\n[1]-Add\n[2]-Search\n[3]-Delete\n[4]-View all CPUS\n[5]-View all Items Cart\n[6]-Back");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        add();
                        break;
                    case "2":
                        total();
                        break;
                    case "3":
                        delete();
                        break;
                    case "4":
                        viewAllCpus();
                        break;
                    case "5":
                        viewAllItemsCart();
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
        System.out.println("Digite o modelo que deseja adicionar");
        String model = scanner.nextLine();
        facade.clientAdd(model);
    }

    public void total() {
        facade.clientTotal();
    }

    public void delete() {
        System.out.println("Digite o modelo que deseja adicionar");
        String model = scanner.nextLine();
        facade.clientDelete(model);
    }

    public void viewAllCpus() {
        System.out.println(facade.clientViewAllCpus().toString());
    }

    public void viewAllItemsCart() {
       System.out.println(facade.clientviewAllItemsCart().toString());
    }
}
