package br.com.ifpe.apresentation;

import java.util.Scanner;

public class ClientGUI {
	
	public void gui() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n[1]-Add\n[2]-Search\n[3]-Delete\n[4]-View all");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
//				add();
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
