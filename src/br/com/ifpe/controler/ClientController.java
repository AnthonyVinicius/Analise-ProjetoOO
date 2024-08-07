package br.com.ifpe.controler;
import java.util.List;
import java.util.function.Predicate;
import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.persistence.GenericDAO;
import br.com.ifpe.services.DAOFactory;

public class ClientController{

	GenericDAO<CpuAbstract> cpuDAO = DAOFactory.createDAO(CpuAbstract.class);//mudar depois 

	public CpuAbstract search(String model) {
		Predicate<CpuAbstract> foundCpu = cpu -> cpu.getModel().equals(model);
		return cpuDAO.search(foundCpu);
	}

	public void add(CpuAbstract cpu) {

	}

	public void delete(String model) {

	}

	public List<CpuAbstract> viewAll() {
		return cpuDAO.listAll();
	}
}