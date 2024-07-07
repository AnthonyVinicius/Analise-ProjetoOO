package br.com.ifpe.entities;

public class BiografiaBuilder {
	
	private BiografiaBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public BiografiaBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	public BiografiaBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public BiografiaBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	public BiografiaBuilder ano(int ano) {
		this.ano = ano;
		return this;
	}
	
	public Biografia build() {
		return new Biografia(titulo, autor, ano, isbn);
	}
	
	public static BiografiaBuilder creatBiografiaBuilder(){
		return new BiografiaBuilder();
	}
	
}
