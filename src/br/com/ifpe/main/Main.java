package br.com.ifpe.main;
import java.util.Scanner;

import br.com.ifpe.apresentation.ClientGUI;
import br.com.ifpe.apresentation.EmployeeGUI;

public class Main {
	public static void main(String[] args) {
		
	}
		EmployeeGUI Employee = new EmployeeGUI();
		ClientGUI Client = new ClientGUI();
		
		public void guiCPU() {
			while (true) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("\n[1]-Client\n[2]-Employee CPU\n");
				String option = scanner.nextLine();

				switch (option) {
				case "1":
					Client.gui();
					break;
				case "2":
					Employee.gui();;		
					break;
				default:
					System.out.println("O valor " + option + " é invalido");
					break;
				}
			}
		}

	}
