package br.com.ifpe.utils;

import br.com.ifpe.controler.EmployeeController;
import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.AmdCpu;
import br.com.ifpe.entities.AmdCpuBuilder;

public class EntitieLoad {
	public void loadEntitie() {		
		EmployeeController controller = new EmployeeController();
		IntelCpu i33710 = new IntelCpuBuilder()
				.model("I3 3710")
				.socket("LGA 775")
				.core(6)
				.threads(12)
				.hrz(3.4)
				.price(13.50)
				.build();

		IntelCpu i53600 = new IntelCpuBuilder()
				.model("I5 3600")
				.socket("LGA 775")
				.core(6)
				.threads(12)
				.hrz(3.4)
				.price(13.50)
				.build();

		AmdCpu r55600 = new AmdCpuBuilder()
				.model("R5 5600")
				.socket("AM4")
				.core(6)
				.threads(12)
				.hrz(4.6)
				.price(130)
				.build();


		AmdCpu r97600 = new AmdCpuBuilder()
				.model("R9 7600")
				.socket("AM4")
				.core(6)
				.threads(12)
				.hrz(4.6)
				.price(130)
				.build();
		System.out.println("Iniciando o registro das CPUs...");
		controller.register(i33710);
		controller.register(i53600);
		controller.register(r55600);
		controller.register(r97600);
		System.out.println("Registro das CPUs concluído.");
	}
}
