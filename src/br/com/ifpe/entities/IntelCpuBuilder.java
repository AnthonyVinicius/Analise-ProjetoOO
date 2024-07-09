package br.com.ifpe.entities;

public class IntelCpuBuilder {
	
	private IntelCpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public IntelCpuBuilder isbn(String isbn) {
		this.isbn = isbn;
		return this;
	}
	public IntelCpuBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public IntelCpuBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	public IntelCpuBuilder ano(int ano) {
		this.ano = ano;
		return this;
	}
	
	public IntelCpu build() {
		return new IntelCpu(titulo, autor, ano, isbn);
	}
	
	public static IntelCpuBuilder creatBiografiaBuilder(){
		return new IntelCpuBuilder();
	}
	
}
