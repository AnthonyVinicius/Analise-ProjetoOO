package br.com.ifpe.presentation;

import java.util.Scanner;

import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.AmdCpuBuilder;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class EmployeeGUI {
    EmployeeFacade facade = new EmployeeFacade();
    Scanner scanner = new Scanner(System.in);

    public void gui() {
        boolean running = true;
        while (running) {
            try {
                System.out.println("\n[1]-Register CPU\n[2]-Search CPU\n[3]-Delete CPU\n[4]-View all CPUs\n[5]-Back");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        register();
                        break;
                    case "2":
                        search();
                        break;
                    case "3":
                        delete();
                        break;
                    case "4":
                        viewAll();
                        break;
                    case "5":
                        running = false;
                        back();
                }
            } catch (Exception e) {
                System.out.println("Invalid Code: " + e.getMessage());
            }
        }
    }

    private void register() {
        String model;
        String socket;
        int core;
        int threads;
        double hrz;
        double price;

        System.out.print("Which CPU model do you want to add?: ");
        System.out.println("\nIntel [1]\nRyzen [2]");
        int modelChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the model:");
        model = scanner.nextLine().toLowerCase().replace(" ", "");
        if (facade.alreadyRegister(model)) {
            System.out.println("Enter the socket:");
            socket = scanner.nextLine();

            System.out.println("Enter the number of cores:");
            core = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the number of threads:");
            threads = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the frequency:");
            hrz = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter the price:");
            price = scanner.nextDouble();
            scanner.nextLine();
            if (modelChoice == 1) {
                facade.register(createIntel(model, socket, core, threads, hrz, price));
            } else if (modelChoice == 2) {
                facade.register(createAMD(model, socket, core, threads, hrz, price));
            } else {
                System.out.println("Model not available in the system");
            }
        }
    }

    private void search() {
        System.out.println("Enter the model:");
        String model = scanner.nextLine().toLowerCase().replace(" ", "");
        CpuAbstract result = facade.search(model);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Object not found in the system");
        }
    }

    private void delete() {
        System.out.println("Enter the model:");
        String model = scanner.nextLine().toLowerCase().replace(" ", "");
        facade.delete(model);
    }

    private void viewAll() {
        System.out.println(facade.viewAll().toString());
    }

    private CpuAbstract createIntel(String model, String socket, int core, int threads, double hrz, double price) {
        return new IntelCpuBuilder()
                .model(model)
                .socket(socket)
                .core(core)
                .threads(threads)
                .hrz(hrz)
                .price(price)
                .build();
    }

    private CpuAbstract createAMD(String model, String socket, int core, int threads, double hrz, double price) {
        return new AmdCpuBuilder()
                .model(model)
                .socket(socket)
                .core(core)
                .threads(threads)
                .hrz(hrz)
                .price(price)
                .build();
    }

    public void back() {
        Menu menu = new Menu();
        menu.menu();
    }
}
