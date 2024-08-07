package br.com.ifpe.controller;
import java.util.List;
import java.util.function.Predicate;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class ClientController{
	public List cart;

	GenericDAO<CpuAbstract> cpuDAO = DAOFactory.createDAO(CpuAbstract.class);//mudar depois 


	public CpuAbstract search(String model) {
		Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equals(model);
		return cpuDAO.search(foundCpu);
	}

	public List<CpuAbstract> add(CpuAbstract cpu) {
	search(cpu.getModel());
	cart.add(cpu);
	return cart;
	}

	public void delete(String model) {

	}

	public List<CpuAbstract> viewAll() {
		return cpuDAO.listAll();
	}
}