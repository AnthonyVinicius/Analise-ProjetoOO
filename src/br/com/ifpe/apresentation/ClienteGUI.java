package br.com.ifpe.apresentation;

import java.util.Scanner;

import br.com.ifpe.persistence.CpuDAO;

public class ClienteGUI {

    public void guiClient() {
        String model;
        int amount;
        double price;
        
        try (Scanner scanner = new Scanner(System.in)) {
            CpuDAO cpuDao = new CpuDAO();

            while (true) {
                System.out.println("\n[1]-Adicionar Placa\n[2]-Calcular Preço\n[3]-Ver todas as Placas");
                String option = scanner.nextLine();

                switch (option) {
                    case "1": // Adicionar Placa
                        System.out.println("Digite o modelo da Placa:");
                        model = scanner.nextLine().toLowerCase().replace(" ", "");
                        
                        System.out.println("Digite a quantidade:");
                        amount = scanner.nextInt();
                        scanner.nextLine();

                        Placa placa = placaDAO.search(model);
                        if (placa != null) {
                            placa.setamount(placa.getamount() + amount);
                            placaDAO.update(placa);
                            System.out.println("Placa adicionada com sucesso.");
                        } else {
                            System.out.println("model não encontrado no sistema.");
                        }
                        break;

                    case "2": // Calcular Preço
                        System.out.println("Digite o model da Placa:");
                        model = scanner.nextLine().toLowerCase().replace(" ", "");

                        System.out.println("Digite a amount:");
                        amount = scanner.nextInt();
                        scanner.nextLine();

                        placa = placaDAO.search(model);
                        if (placa != null) {
                            double precoTotal = amount * placa.getPreco();
                            System.out.println("O preço total é: " + precoTotal);
                        } else {
                            System.out.println("model não encontrado no sistema.");
                        }
                        break;

                    case "3": // Ver todas as Placas
                        System.out.println(placaDAO.listAll());
                        break;

                    default:
                        System.out.println("O valor " + option + " é inválido.");
                        break;
                }
            }
        }
    }
}
