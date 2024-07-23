package br.com.ifpe.utils;

import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.persistence.CpuDAO;

public class Util {
	 CpuDAO cpuDAO = CpuDAO.getInstance();


	IntelCpu intelCpu = new IntelCpuBuilder()
			.model("i3 5600")
			.socket("LGA 775")
			.core(8)
			.threads(16)
			.hrz(2.4)
			.price(1200)
			.build();
	
	cpuDAO.register(intelCpu);
}
