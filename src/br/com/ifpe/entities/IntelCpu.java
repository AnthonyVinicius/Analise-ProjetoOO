package br.com.ifpe.entities;

import br.com.ifpe.entities.abtract.CpuAbstract;

public class IntelCpu extends CpuAbstract{

	public IntelCpu() {
		// TODO Auto-generated constructor stub
	}

	public IntelCpu(String modelo, String socket, int nucleos, int threads, double hrz) {
		super(modelo, socket, nucleos, threads, hrz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IntelCpu [getModelo()=" + getModelo() + ", getSocket()=" + getSocket() + ", getNucleos()="
				+ getNucleos() + ", getThreads()=" + getThreads() + ", getHrz()=" + getHrz() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
