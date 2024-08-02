package br.com.ifpe.entities;

public class EmployeeBuilder {
	
	public EmployeeBuilder() {
		// TODO Auto-generated constructor stub
	}

	private String nome;
	private String cpf;
	private String idEmployee;

	public EmployeeBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}

	public EmployeeBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public EmployeeBuilder idEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
		return this;
	}

	public Employee build() {
		return new Employee(nome, cpf, idEmployee);
	}
}
