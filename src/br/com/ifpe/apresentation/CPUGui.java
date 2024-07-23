package br.com.ifpe.apresentation;

import java.util.Scanner;

import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.RyzenCpu;
import br.com.ifpe.entities.RyzenCpuBuilder;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.controler.CpuControler;

public class CPUGui {
	CpuControler cpuControler = new CpuControler();
	Scanner scanner = new Scanner(System.in);
	GenericDAO genericDAO = new GenericDAO();

	public void guiCPU() {



		while (true) {
			System.out.println("\n[1]-Register CPU\n[2]-Search CPU\n[3]-Delete CPU\n[4]-View all CPUs");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
				registerCPU();
				break;

			case "2":
				search();
				
				break;

			case "3":

				break;

			case "4":
				cpuControler.viewAllCPU();

				break;

			default:
				System.out.println("O valor " + option + " é invalido");
				break;
			}
		}
	}



	private void registerCPU() {
		String model;
		String socket;
		int core;
		int threads;
		double hrz;
		double price;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Qual Modelo de CPU deseja Adicionar?: ");

		System.out.println("\nIntel [1]\nRyzen [2]");
		int modelChoice = scanner.nextInt();
		scanner.nextLine();

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

		System.out.println("Digite o Preço:");
		price = scanner.nextDouble();
		scanner.nextLine();

		IntelCpu intelCpu = new IntelCpuBuilder()
				.model(model)
				.socket(socket)
				.core(core)
				.threads(threads)
				.hrz(hrz)
				.price(price)
				.build();
		cpuControler.registerCPU(intelCpu);
	}
	
	private void search() {
		
		System.out.println("Digite o Modelo:");	
		String model = scanner.nextLine().toLowerCase().replace(" ", "");
		cpuControler.searchCPU(model);
	}
}

//        if (gcpu.search(model) == null) {

//            System.out.println("Digite o Socket:");
//            String socket = scanner.nextLine();
//            
//            System.out.println("Digite a quantidade de Core:");
//            int core = scanner.nextInt();
//            scanner.nextLine();
//            
//            System.out.println("Digite o Threads:");
//            int threads = scanner.nextInt();
//            scanner.nextLine();
//            
//            System.out.println("Digite a Frequência:");
//            double hrz = scanner.nextDouble();
//            scanner.nextLine();
//            
//            System.out.println("Digite o Preço:");
//            double price = scanner.nextDouble();
//            scanner.nextLine();
//            
//	 	        if (modelChoice == 1) {
//                IntelCpu intelCpu = new IntelCpuBuilder()
//                    .model(model)
//                    .socket(socket)
//                    .core(core)
//                    .threads(threads)
//                    .hrz(hrz)
//                    .price(price)
//                    .build();
//                registerCPU(scanner, genericDAO);
//            } else if (modelChoice == 2) {
//                RyzenCpu ryzenCpu = new RyzenCpuBuilder()
//                    .model(model)
//                    .socket(socket)
//                    .core(core)
//                    .threads(threads)
//                    .hrz(hrz)
//                    .price(price)
//                    .build();
//                genericDAO.register(ryzenCpu);
//                
//            } else {
//                System.out.println("Modelo Não Presente no Sistema.");
//            }
//        } else {
//            System.out.println("Modelo já registrado no sistema");
//        }
//    }
//
//    private void searchCPU(Scanner scanner, GenericDAO genericDAO) {
//        System.out.print("Digite o Modelo: ");
//        String model = scanner.nextLine().toLowerCase().replace(" ", "");
//        System.out.println(genericDAO.search(model));
//    }
//
//    private void deleteCPU(Scanner scanner, GenericDAO genericDAO) {
//        System.out.print("Digite o Modelo: ");
//        String model = scanner.nextLine().toLowerCase().replace(" ", "");
//        genericDAO.delete(model);
//        System.out.println("Modelo Removido do Sistema");
//    }
//
//    private void viewAllCPUs(GenericDAO genericDAO) {
//        System.out.println(genericDAO.listAll());
//    }
