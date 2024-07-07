package br.com.ifpe.entities;

public class LivroBuilder {
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public LivroBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	
	public LivroBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	
	public LivroBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	
	public LivroBuilder ano(int ano) {
		this.ano = ano;
		return this;
	}
	
	public Livro build() {
		return new Livro(isbn, titulo, autor, ano);
	}
}
