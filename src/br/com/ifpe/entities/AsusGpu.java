package br.com.ifpe.entities;

import br.com.ifpe.entities.abtract.GpuAbstract;

public class AsusGpu extends GpuAbstract{
	
	private int quantidadeCapitulos;
	
	public AsusGpu() {
		// TODO Auto-generated constructor stub
	}

	public AsusGpu(String titulo, String autor, int ano,  int quantidadeCapitulos,String isbn) {
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
