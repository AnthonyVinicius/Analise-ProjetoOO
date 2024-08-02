package br.com.ifpe.entities;

public class ClientBuilder {
	
	public ClientBuilder() {
		// TODO Auto-generated constructor stub
	}

	private String nome;
	private String cpf;
	private String email;

	public ClientBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}

	public ClientBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public ClientBuilder email(String email) {
		this.email = email;
		return this;
	}

	public Client build() {
		return new Client(nome, cpf, email);
	}
}
