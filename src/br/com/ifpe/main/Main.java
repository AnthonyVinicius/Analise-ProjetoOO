package br.com.ifpe.main;
import java.util.Scanner;

import br.com.ifpe.apresentation.ClientGUI;
import br.com.ifpe.apresentation.EmployeeGUI;
import br.com.ifpe.utils.EntitieLoad;

public class Main {
	public static void main(String[] args) {
		
		EntitieLoad load = new EntitieLoad();
		load.loadEntities();

		EmployeeGUI Employee = new EmployeeGUI();
		ClientGUI Client = new ClientGUI();
		Scanner scanner = new Scanner(System.in);


		while (true) {
			System.out.print("\n[1]-Client\n[2]-Employee\n");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
				Client.gui();
				break;
			case "2":
				Employee.gui();		
				break;
			default:
				System.out.println("O valor " + option + " é invalido");
				break;
			}
		}

	}
}

