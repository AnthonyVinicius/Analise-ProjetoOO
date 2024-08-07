package br.com.ifpe.main;
import java.util.Scanner;

import br.com.ifpe.presentation.ClientGUI;
import br.com.ifpe.presentation.EmployeeGUI;
import br.com.ifpe.presentation.Menu;
import br.com.ifpe.utils.EntitieLoad;

public class Main {
	public static void main(String[] args) {

		EntitieLoad load = new EntitieLoad();
		load.loadEntities();

		Menu menu = new Menu();
		menu.menu();
	}
}

