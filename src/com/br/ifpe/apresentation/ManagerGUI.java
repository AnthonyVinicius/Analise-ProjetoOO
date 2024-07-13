package com.br.ifpe.apresentation;

import java.util.Scanner;

import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.RyzenCpu;
import br.com.ifpe.entities.RyzenCpuBuilder;
import br.com.ifpe.persistence.CpuDAO;

public class ManagerGUI {
    public static void main(String[] args) {

        String model;
        String socket;
        int core;
        int threads;
        double hrz;

        Scanner scanner = new Scanner(System.in);
        CpuDAO cpuDAO = new CpuDAO();

        while (true) {

            System.out.println("\n[1]-Register CPU\n[2]-Update CPU\n[3]-Search CPU\n[4]-Delete CPU\n[5]-View all CPUs");
            String option = scanner.nextLine();

            switch (option) {

            case "1": // Register
                System.out.print("Qual Modelo de CPU deseja Adicionar?: ");

                System.out.println("\nIntel [1]\nRyzen [2]");
                int model_choice = scanner.nextInt();
                scanner.nextLine();

                if (model_choice == 1) {

                    System.out.println("Digite o Modelo:");
                    model = scanner.nextLine().toLowerCase().replace(" ", "");

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

                    IntelCpu intelCpu = new IntelCpuBuilder()
                            .model(model)
                            .socket(socket)
                            .core(core)
                            .threads(threads)
                            .hrz(hrz)
                            .build();

                    cpuDAO.register(intelCpu);

                } else if (model_choice == 2) {
                    System.out.println("Digite o Modelo:");
                    model = scanner.nextLine().toLowerCase().replace(" ", "");

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

                    RyzenCpu ryzenCpu = new RyzenCpuBuilder()
                            .model(model)
                            .socket(socket)
                            .core(core)
                            .threads(threads)
                            .hrz(hrz)
                            .build();
                    cpuDAO.register(ryzenCpu);

                } else {
                    System.out.println("Modelo Não Presente no Sistema.");
                    break;
                }
                break;

                /*			
            case "2": // Update 
                System.out.print("Digite a placa: ");
                plate = scanner.nextLine();
                System.out.println(carController.read(plate));
                System.out.println("Atualizando carro...");
                System.out.println("Tração: ");
                String traction = scanner.nextLine();
                Client client = Client.ClientBuilder().build();
                carController.update(plate, traction, client);

                break;*/

            case "3": // Search
                System.out.print("Digite o Modelo: ");
                model = scanner.nextLine();
                System.out.println(cpuDAO.search(model));
                break;

            case "4": // Delete
                System.out.print("Digite o Modelo ");
                model = scanner.nextLine();
                cpuDAO.delete(model);
                System.out.println("Modelo Removido do Sistema");
                break;

            case "5": // All
                System.out.println(cpuDAO.listAll());
                break;

            default:
                System.out.println("O valor " + option + " é invalido");
                break;
            }

        }
    }
}
