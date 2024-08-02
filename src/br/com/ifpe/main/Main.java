package br.com.ifpe.main;
import br.com.ifpe.apresentation.CPUGui;

public class Main {
	public static void main(String[] args) {
		CPUGui gui = new CPUGui();
		gui.guiCPU();		
	}
	public void guiCPU() {
		while (true) {
			System.out.println("\n[1]-Register CPU\n[2]-Search CPU\n[3]-Delete CPU\n[4]-View all CPUs");
			String option = scanner.nextLine();

			switch (option) {
			case "1":
				register();
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
			default:
				System.out.println("O valor " + option + " é invalido");
				break;
			}
		}
}
