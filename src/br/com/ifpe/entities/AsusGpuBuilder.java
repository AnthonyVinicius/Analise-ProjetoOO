package br.com.ifpe.entities;

public class AsusGpuBuilder {
	
	private AsusGpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private int quantidadeCapitulos;
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public AsusGpuBuilder quantidadeCapitulo(int quantidadeCapitulos) {
		this.quantidadeCapitulos = quantidadeCapitulos;
		return this;
	}
	
	public AsusGpuBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	public AsusGpuBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public AsusGpuBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	public AsusGpuBuilder ano(int ano) {
		this.ano = ano;
		return this;
	}
	
	public AsusGpu build() {
		return new AsusGpu(titulo, autor, ano, quantidadeCapitulos, isbn);
	}
	
	public static AsusGpuBuilder creatMangaBuilder(){
		return new AsusGpuBuilder();
	}
	
}
