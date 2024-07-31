package br.com.ifpe.entities;

import br.com.ifpe.entities.abstractclass.PersonAbstract;

public class Employee extends PersonAbstract {
	private String idEmployee;
	
	public Employee(String nome, String cpf) {
		super(nome, cpf);
		// TODO Auto-generated constructor stub
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + "]";
	}
}
