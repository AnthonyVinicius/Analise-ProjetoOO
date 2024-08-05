package br.com.ifpe.apresentation;
import java.util.List;

import br.com.ifpe.controler.EmployeeController;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class EmployeeFacade {

	EmployeeController  controller = new EmployeeController();


	public void register(CpuAbstract cpu) {
		controller.register(cpu);
	}
	
	public CpuAbstract search(String model) {
		return controller.search(model);
	}
	
	public void delete(String model) {
		controller.delete(model);
	}
	
	public List<CpuAbstract> viewAll() {
		return controller.viewAll();
	}
}

