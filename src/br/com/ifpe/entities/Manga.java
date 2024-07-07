package br.com.ifpe.entities;

import br.com.ifpe.entities.abtract.LivroAbstract;

public class Manga extends LivroAbstract{
	
	private int quantidadeCapitulos;
	
	public Manga() {
		// TODO Auto-generated constructor stub
	}

	public Manga(String titulo, String autor, int ano,  int quantidadeCapitulos,String isbn) {
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
