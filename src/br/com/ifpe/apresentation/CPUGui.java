package br.com.ifpe.apresentation;

import java.util.Scanner;

import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.RyzenCpu;
import br.com.ifpe.entities.RyzenCpuBuilder;
import br.com.ifpe.entities.abtract.CpuAbstract;
import br.com.ifpe.persistence.CpuDAO;

public class CPUGui {

    public void guiCPU() {
        String model;
        String socket;
        int core;
        int threads;
        double hrz;
        double price;

        try (Scanner scanner = new Scanner(System.in)) {
            CpuDAO cpuDAO = new CpuDAO().getInstance();

            while (true) {

                System.out.println("\n[1]-Register CPU\n[2]-Search CPU\n[3]-Delete CPU\n[4]-View all CPUs");
                String option = scanner.nextLine();

                switch (option) {

                    case "1": // Register
                    	System.out.print("Qual Modelo de CPU deseja Adicionar?: ");

                    	System.out.println("\nIntel [1]\nRyzen [2]");
                    	int model_choice = scanner.nextInt();
                    	scanner.nextLine();

                    	System.out.println("Digite o Modelo:");
                    	model = scanner.nextLine().toLowerCase().replace(" ", "");

                    	if (cpuDAO.search(model) == null) {
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
                    	    
                    	    if (model_choice == 1) {
                    	        IntelCpu intelCpu = new IntelCpuBuilder()
                    	            .model(model)
                    	            .socket(socket)
                    	            .core(core)
                    	            .threads(threads)
                    	            .hrz(hrz)
                    	            .price(price)
                    	            .build();
                    	        cpuDAO.register(intelCpu);
                    	        
                    	    } else if (model_choice == 2) {
                    	        RyzenCpu ryzenCpu = new RyzenCpuBuilder()
                    	            .model(model)
                    	            .socket(socket)
                    	            .core(core)
                    	            .threads(threads)
                    	            .hrz(hrz)
                    	            .price(price)
                    	            .build();
                    	        cpuDAO.register(ryzenCpu);
                    	        
                    	    } else {
                    	        System.out.println("Modelo Não Presente no Sistema.");
                    	    }
                    	} else {
                    	    System.out.println("Modelo já registrado no sistema");
                    	}
                    	break;


                    case "2": // Search
                        System.out.print("Digite o Modelo: ");
                        model = scanner.nextLine().toLowerCase().replace(" ", "");
                        System.out.println(cpuDAO.search(model));
                        break;

                    case "3": // Delete
                        System.out.print("Digite o Modelo: ");
                        model = scanner.nextLine().toLowerCase().replace(" ", "");
                        cpuDAO.delete(model);
                        System.out.println("Modelo Removido do Sistema");
                        break;

                    case "4": // All
                        System.out.println(cpuDAO.listAll());
                        break;

                    default:
                        System.out.println("O valor " + option + " é invalido");
                        break;
                }
            }
        }
    }
}
