package br.com.ifpe.entities;

import br.com.ifpe.entities.abstractclass.PersonAbstract;

public class Employee extends PersonAbstract {
	private String idEmployee;
	
	 

	public Employee(String nome, String cpf, String idEmployee) {
		super(nome, cpf);
		this.idEmployee = idEmployee;
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	public String toString() {
		return "Employee: \nNome: " + getNome() + "\nCPF: " + getCpf() + ",\nIdEmployee: "
				+ idEmployee + "]";
	}
}
