package br.com.ifpe.apresentation;

import java.util.List;
import java.util.Scanner;

import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.RyzenCpu;
import br.com.ifpe.entities.RyzenCpuBuilder;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.controler.CpuControler;

public class CPUGui {
	CpuControler cpuControler = new CpuControler();
	Scanner scanner = new Scanner(System.in);

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
				delete();
				break;
			case "4":
				viewAllCPUs();
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
		if(modelChoice == 1 ) {

			IntelCpu intelCpu = new IntelCpuBuilder()
					.model(model)
					.socket(socket)
					.core(core)
					.threads(threads)
					.hrz(hrz)
					.price(price)
					.build();
			cpuControler.registerCPU(intelCpu);
		}else if(modelChoice == 2 ) {
			RyzenCpu ryzenCpu = new RyzenCpuBuilder()
					.model(model)
					.socket(socket)
					.core(core)
					.threads(threads)
					.hrz(hrz)
					.price(price)
					.build();
			cpuControler.registerCPU(ryzenCpu);
		}else {
			System.out.println("Modelo Indisponivel no Sistema");
		}
	}

	private void search() {
		System.out.println("Digite o Modelo:");
		String model = scanner.nextLine().toLowerCase().replace(" ", "");
		CpuAbstract cpu = cpuControler.searchCPU(model);
		if (cpu != null) {
			System.out.println(cpu);
		} else {
			System.out.println("CPU não encontrada.");
		}
	}

	private void delete() {
		System.out.println("Digite o Modelo:");
		String model = scanner.nextLine().toLowerCase().replace(" ", "");
		cpuControler.deleteCPU(model);
	}

	private void viewAllCPUs() {
	System.out.println(cpuControler.viewAllCPU().toString());
	}
}
