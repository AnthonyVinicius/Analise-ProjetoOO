package br.com.ifpe.entities;

import br.com.ifpe.entities.abstractclass.PersonAbstract;

public class Client extends PersonAbstract{
	private String email;
	
	public Client(String nome, String cpf) {
		super(nome, cpf);
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [email=" + email + "]";
	}
}
