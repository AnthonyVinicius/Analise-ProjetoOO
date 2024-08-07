package br.com.ifpe.presentation;

import java.util.Scanner;

public class Menu {
    EmployeeGUI Employee = new EmployeeGUI();
    ClientGUI Client = new ClientGUI();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            try {
                System.out.print("\n[1]-Client\n[2]-Employee\n");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        Client.gui();
                        break;
                    case "2":
                        Employee.gui();
                }

            } catch (Exception e) {
                System.out.println("Invalid Code: " + e.getMessage());
            }
        }
    }
}
