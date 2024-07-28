package br.com.ifpe.controler;

import java.util.function.Predicate;

import br.com.ifpe.entities.abtract.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class CpuControler {
	
	
	
	public CpuControler() {
		// TODO Auto-generated constructor stub
	}
	
	GenericDAO<CpuAbstract> cpuDAO = DAOFactory.createDAO();
	
	public CpuAbstract searchCPU(String model) {
		Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equals(model);
		return cpuDAO.search(foundCpu);
	}
	
	
	public void registerCPU(CpuAbstract cpu) {
		cpuDAO.register(cpu);
		
	}
	
	public void viewAllCPU() {
		cpuDAO.listAll();
	}
}
