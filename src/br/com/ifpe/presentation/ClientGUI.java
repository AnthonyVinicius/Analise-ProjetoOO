package br.com.ifpe.presentation;

import java.util.Scanner;

public class ClientGUI {

    public void gui() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            try {

                System.out.println("\n[1]-Add\n[2]-Search\n[3]-Delete\n[4]-View all\n[5]-Back");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        add();
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
                    case "5":
                        running = false;
                        back();
                }
            } catch (Exception e) {
                System.out.println("Invalid Code: " + e.getMessage());
            }
        }
    }

    public void add() {

    }

    public void search() {

    }

    public void delete() {

    }

    public void viewAll() {

    }

    public void back() {
        Menu menu = new Menu();
        menu.menu();
    }

}
