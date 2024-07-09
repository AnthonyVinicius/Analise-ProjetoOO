package br.com.ifpe.entities;

public class RyzenCpuBuilder {
	
	private RyzenCpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private int quantidadeCapitulos;
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public RyzenCpuBuilder quantidadeCapitulo(int quantidadeCapitulos) {
		this.quantidadeCapitulos = quantidadeCapitulos;
		return this;
	}
	
	public RyzenCpuBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	public RyzenCpuBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public RyzenCpuBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	public RyzenCpuBuilder ano(int ano) {
		this.ano = ano;
		return this;
	}
	
	public RyzenCpu build() {
		return new RyzenCpu(titulo, autor, ano, quantidadeCapitulos, isbn);
	}
	
	public static RyzenCpuBuilder creatMangaBuilder(){
		return new RyzenCpuBuilder();
	}
	
}
