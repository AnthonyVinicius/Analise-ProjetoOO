package br.com.ifpe.entities;

public class MangaBuilder {
	
	private MangaBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private int quantidadeCapitulos;
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public MangaBuilder quantidadeCapitulo(int quantidadeCapitulos) {
		this.quantidadeCapitulos = quantidadeCapitulos;
		return this;
	}
	
	public MangaBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	public MangaBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public MangaBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	public MangaBuilder ano(int ano) {
		this.ano = ano;
		return this;
	}
	
	public Manga build() {
		return new Manga(titulo, autor, ano, quantidadeCapitulos, isbn);
	}
	
	public static MangaBuilder creatMangaBuilder(){
		return new MangaBuilder();
	}
	
}
