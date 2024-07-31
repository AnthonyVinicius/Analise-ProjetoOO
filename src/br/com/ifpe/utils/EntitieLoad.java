package br.com.ifpe.utils;

import br.com.ifpe.controler.CpuControler;
import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.RyzenCpu;
import br.com.ifpe.entities.RyzenCpuBuilder;

public class EntitieLoad {

	IntelCpu i33710 = new IntelCpuBuilder()
			.model("I3 3710")
			.socket("LGA 775")
			.core(6)
			.threads(12)
			.hrz(3.4)
			.price(13.50)
			.build();

	RyzenCpu r55600 = new RyzenCpuBuilder()
			.model("R5 5600")
			.socket("AM4")
			.core(6)
			.threads(12)
			.hrz(4.6)
			.price(130)
			.build();
	
	CpuControler cpuControler = new CpuControler();
	

}
