package br.com.ifpe.entities;

public class MsiGpuBuilder {
	
	private MsiGpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public MsiGpuBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	public MsiGpuBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public MsiGpuBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	public MsiGpuBuilder ano(int ano) {
		this.ano = ano;
		return this;
	}
	
	public MsiGpu build() {
		return new MsiGpu(titulo, autor, ano, isbn);
	}
	
	public static MsiGpuBuilder creatBiografiaBuilder(){
		return new MsiGpuBuilder();
	}
	
}
