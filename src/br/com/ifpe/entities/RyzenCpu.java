package br.com.ifpe.entities;

import br.com.ifpe.entities.abtract.CpuAbstract;

public class RyzenCpu extends CpuAbstract{
	
	private int quantidadeCapitulos;
	
	public RyzenCpu() {
		// TODO Auto-generated constructor stub
	}

	public RyzenCpu(String titulo, String autor, int ano,  int quantidadeCapitulos,String isbn) {
		super(isbn, titulo, autor, ano);
		this.quantidadeCapitulos = quantidadeCapitulos;
		// TODO Auto-generated constructor stub
	}

	public int getQuantidadeCapitulos() {
		return quantidadeCapitulos;
	}

	public void setQuantidadeCapitulos(int quantidadeCapitulos) {
		this.quantidadeCapitulos = quantidadeCapitulos;
	}
	
	

}	
