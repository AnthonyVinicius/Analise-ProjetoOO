package br.com.ifpe.main;
import br.com.ifpe.entities.*;
import br.com.ifpe.persistence.CpuDAO;

public class Main {
	public static void main(String[] args) {
		CpuDAO cpuDAO = new CpuDAO();
		
		IntelCpu intelCpu = new IntelCpuBuilder()
				.model("Intel Core i7")
				.socket("LGA 1200")
				.core(8)
				.threads(16)
				.hrz(4.5)
				.build();
		RyzenCpu ryzenCpu = new RyzenCpuBuilder()
				.model("Ryzen 5700x")
				.build();
		
		System.out.println(ryzenCpu.toString());
		
		cpuDAO.register(intelCpu);
		cpuDAO.register(ryzenCpu);
		cpuDAO.listAll();
		
							
//		System.out.println(intelCpu.toString());
		
	}
}
