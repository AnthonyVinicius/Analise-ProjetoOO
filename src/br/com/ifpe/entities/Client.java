package br.com.ifpe.entities;

import br.com.ifpe.entities.abstractclass.PersonAbstract;

public class Client extends PersonAbstract{
	
	private String email;
	
	public Client(String nome, String cpf, String email) {
		super(nome, cpf);
		this.email = email;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Client: \nNome: " + getNome() + "\nCPF: " + getCpf() + ",\nEmail: "
				+ email + "]";
	}
}
