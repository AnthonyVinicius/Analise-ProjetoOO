package br.com.ifpe.entities.abstractclass;

public abstract class PersonAbstract {
	private String nome;
	private String cpf;
	
		
	public PersonAbstract(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
