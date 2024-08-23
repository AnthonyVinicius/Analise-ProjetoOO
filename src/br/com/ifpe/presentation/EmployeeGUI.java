package br.com.ifpe.presentation;

import java.util.Scanner;

import br.com.ifpe.entities.AmdCpu;
import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.AmdCpuBuilder;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.Logger;

public class EmployeeGUI {
    Facade facade = new Facade();
    Scanner scanner = new Scanner(System.in);

    public void gui() {
        boolean running = true;
        try {
        while (running) {
                System.out.println("===========================================");
                System.out.println("[1]-Register CPU\n[2]-Read CPU\n[3]-Delete CPU\n[4]-Update CPU\n[5]-View all CPUs\n[6]-Back");
                System.out.println("===========================================");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        register();
                        break;
                    case "2":
                        read();
                        break;
                    case "3":
                        delete();
                        break;
                    case "4":
                        update();
                        break;
                    case "5":
                        viewAll();
                        break;
                    case "6":
                        running = false;
                }
            }
            }catch (Exception e) {
            System.out.println("Invalid Code: " + e.getMessage());
            Logger.error(e.getMessage());
        }
}

    private void register() {

        System.out.print("Which CPU model do you want to add?: ");
        System.out.println("\nIntel [1]\nRyzen [2]");
        String modelChoice = scanner.nextLine();
        if (modelChoice.equals("1")|| modelChoice.equals("2")) {

            System.out.println("Enter the model:");
            String model = scanner.nextLine().toLowerCase().replace(" ", "");
            System.out.println("Enter the socket:");
            String socket = scanner.nextLine();

            System.out.println("Enter the number of cores:");
            int core = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the number of threads:");
            int threads = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the frequency:");
             double hrz = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter the price:");

            double price = Double.parseDouble(scanner.nextLine());

            if (modelChoice.equals("1")) {

                facade.employeeRegister(createIntel(model, socket, core, threads, hrz, price));
                System.out.println("Model successfully registered.");
            } else {
                facade.employeeRegister(createAMD(model, socket, core, threads, hrz, price));
                System.out.println("Model successfully registered.");
            }
        } else {
            System.out.println("Model not available in the system");
        }
    }


    private void read() {
        System.out.println("Enter the model:");
        String model = scanner.nextLine().toLowerCase().replace(" ", "");
        System.out.println(facade.employeeRead(model));
    }

    private void delete() {
        System.out.println("Enter the model:");
        String model = scanner.nextLine().toLowerCase().replace(" ", "");
        facade.employeeDelete(model);
        System.out.println("CPU successfully deleted.");
    }


    private void update() {
        System.out.println("Enter the model of the CPU to update:");
        String oldModel = scanner.next().toLowerCase().replace(" ", "");

        CpuAbstract existingCpu = facade.employeeRead(oldModel);

        System.out.println("Enter the new socket:");
        String newSocket = scanner.nextLine();

        System.out.println("Enter the new number of cores:");
        int newCore = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();

        System.out.println("Enter the new number of threads:");
        int newThreads = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();

        System.out.println("Enter the new frequency:");
        double newHrz = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the new price:");
        double newPrice = Double.parseDouble(scanner.nextLine());

        CpuAbstract updatedCpu;

        String cpuType = existingCpu.getClass().getSimpleName();

        if (cpuType.equals("IntelCpu")) {
            updatedCpu = new IntelCpuBuilder()
                    .socket(newSocket)
                    .core(newCore)
                    .threads(newThreads)
                    .hrz(newHrz)
                    .price(newPrice)
                    .build();
        } else if (cpuType.equals("AmdCpu")) {
            updatedCpu = new AmdCpuBuilder()
                    .socket(newSocket)
                    .core(newCore)
                    .threads(newThreads)
                    .hrz(newHrz)
                    .price(newPrice)
                    .build();
        } else {
            System.out.println("Error: Unknown CPU type.");
            System.out.println(cpuType);
            return;
        }

        facade.employeeUpdate(updatedCpu);
        System.out.println("CPU successfully updated.");
    }

    private void viewAll() {
        System.out.println(facade.employeeViewAll().toString());
    }

    private IntelCpu createIntel(String model, String socket, int core, int threads, double hrz, double price){
        return new IntelCpuBuilder()
                .model(model)
                .socket(socket)
                .core(core)
                .threads(threads)
                .hrz(hrz)
                .price(price)
                .build();
    }

    private AmdCpu createAMD(String model, String socket, int core, int threads, double hrz, double price){
        return new AmdCpuBuilder()
                .model(model)
                .socket(socket)
                .core(core)
                .threads(threads)
                .hrz(hrz)
                .price(price)
                .build();
    }

}
