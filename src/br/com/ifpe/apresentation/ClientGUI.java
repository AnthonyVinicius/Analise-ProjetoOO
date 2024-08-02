package br.com.ifpe.apresentation;

import java.util.Scanner;

public class ClientGUI {
	
	public void gui() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n[1]-Add\n[2]-Search CPU\n[3]-Delete CPU\n[4]-View all CPUs");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
//				register();
				break;
			case "2":
//				search();
				break;
			case "3":
//				delete();
				break;
			case "4":
//				viewAll();
				break;
			default:
				System.out.println("O valor " + option + " é invalido");
				break;
			}
		}
	}
}
