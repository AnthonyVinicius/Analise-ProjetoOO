package br.com.ifpe.presentation;

import br.com.ifpe.entities.abstractclass.CpuAbstract;

import java.util.Scanner;

public class ClientGUI {

    public void gui() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            try {

                System.out.println("\n[1]-Add\n[2]-Search\n[3]-Delete\n[4]-View all\n[5]-Back");
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
                        viewAll();
                        break;
                    case "5":
                        running = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid Code: " + e.getMessage());
            }
        }
    }
    Facade facade = new Facade();
    public void add() {
        CpuAbstract cpu = null; //Mudar
	facade.clientAdd(cpu);
    }

    public void total() {
	facade.clientTotal();
    }

    public void delete() {
        String model = null; //Mudar
	facade.clientDelete(model);
    }

    public void viewAll() {
	facade.clientViewAll();
    }
}
