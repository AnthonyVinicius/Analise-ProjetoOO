package br.com.ifpe.entities;

import br.com.ifpe.entities.abtract.CpuAbstract;

public class RyzenCpu extends CpuAbstract{
	
	public RyzenCpu() {
		// TODO Auto-generated constructor stub
	}


	public RyzenCpu(String modelo, String socket, int nucleos, int threads, float hrz) {
		super(modelo, socket, nucleos, threads, hrz);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "RyzenCpu [getModelo()=" + getModelo() + ", getSocket()=" + getSocket() + ", getNucleos()="
				+ getNucleos() + ", getThreads()=" + getThreads() + ", getHrz()=" + getHrz() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}	
