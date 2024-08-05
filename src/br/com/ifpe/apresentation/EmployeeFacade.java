package br.com.ifpe.apresentation;
import br.com.ifpe.controler.EmployeeController;

public class EmployeeFacade {

	EmployeeController  controller = new EmployeeController();


	public void registar() {
		controller.register(null);
	}
	
	public void search() {
		controller.search(null);
	}
	
	public void delete() {
		controller.delete(null);
	}
	
	public void viewAll() {
		controller.viewAll();
	}
}

