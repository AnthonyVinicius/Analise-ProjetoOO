package br.com.ifpe.main;
import br.com.ifpe.entities.*;

public class Main {
	public static void main(String[] args) {
		IntelCpu intelCpu = new IntelCpuBuilder()
							.modelo("Intel Core i7")
							.socket("LGA 1200")
							.nucleos(8)
							.threads(16)
							.hrz(4.5f)
							.build();
							
//		System.out.println(intelCpu.toString());
		
		RyzenCpu ryzenCpu = new RyzenCpuBuilder()
							.modelo("Ryzen 5700x")
							.build();
		
		System.out.println(ryzenCpu.toString());
	}
}
