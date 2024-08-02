package br.com.ifpe.utils;

import br.com.ifpe.controler.CpuControler;
import br.com.ifpe.entities.IntelCpu;
import br.com.ifpe.entities.IntelCpuBuilder;
import br.com.ifpe.entities.RyzenCpu;
import br.com.ifpe.entities.RyzenCpuBuilder;

public class EntitieLoad {
	
	public void entitieLoad() {		
		CpuControler cpuControler = new CpuControler();
		IntelCpu i33710 = new IntelCpuBuilder()
				.model("I3 3710")
				.socket("LGA 775")
				.core(6)
				.threads(12)
				.hrz(3.4)
				.price(13.50)
				.build();
		
		IntelCpu I53600 = new IntelCpuBuilder()
				.model("I5 3600")
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
		
		
		RyzenCpu r97600 = new RyzenCpuBuilder()
				.model("R9 7600")
				.socket("AM4")
				.core(6)
				.threads(12)
				.hrz(4.6)
				.price(130)
				.build();
		cpuControler.register(r55600);
		cpuControler.register(r97600);
		cpuControler.register(i33710);
		cpuControler.register(I53600);
	}

}
