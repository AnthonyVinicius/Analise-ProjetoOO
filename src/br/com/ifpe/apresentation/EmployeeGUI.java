package br.com.ifpe.apresentation;

import java.util.Scanner;

import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.AmdCpu;
import br.com.ifpe.entities.AmdCpuBuilder;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.apresentation.EmployeeFacade;

public class EmployeeGUI {
    EmployeeFacade facade = new EmployeeFacade();
    Scanner scanner = new Scanner(System.in);

    public void gui() {
        while (true) {
            try {
                System.out.println("\n[1]-Register CPU\n[2]-Search CPU\n[3]-Delete CPU\n[4]-View all CPUs");
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
                }
            } catch (Exception e) {
                System.out.println("Código Inválido: " + e.getMessage());
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

        System.out.print("Qual Modelo de CPU deseja Adicionar?: ");
        System.out.println("\nIntel [1]\nRyzen [2]");
        int modelChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o Modelo:");
        model = scanner.nextLine().toLowerCase().replace(" ", "");
        if (facade.alreadyRegister(model)) {
            System.out.println("Digite o Socket:");
            socket = scanner.nextLine();

            System.out.println("Digite a quantidade de Core:");
            core = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o Threads:");
            threads = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite a Frequência:");
            hrz = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Digite o Preço:");
            price = scanner.nextDouble();
            scanner.nextLine();
            if (modelChoice == 1) {
               facade.register( creatIntel(model, socket, core, threads, hrz, price));
            } else if (modelChoice == 2) {
            facade.register( creatAMD(model, socket, core, threads, hrz, price));
            } else {
                System.out.println("Modelo Indisponível no Sistema");
            }
        }
    }

    private void search() {
        System.out.println("Digite o Modelo:");
        String model = scanner.nextLine().toLowerCase().replace(" ", "");
        CpuAbstract result = facade.search(model);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Objeto Não Encontrado no Sistema");
        }
    }

    private void delete() {
        System.out.println("Digite o Modelo:");
        String model = scanner.nextLine().toLowerCase().replace(" ", "");
        facade.delete(model);
    }

    private void viewAll() {
        System.out.println(facade.viewAll().toString());
    }

    private CpuAbstract creatIntel(String model, String socket, int core, int threads, double hrz, double price ){
        return new IntelCpuBuilder()
                .model(model)
                .socket(socket)
                .core(core)
                .threads(threads)
                .hrz(hrz)
                .price(price)
                .build();
    }
    private CpuAbstract creatAMD(String model, String socket, int core, int threads, double hrz, double price ){
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
