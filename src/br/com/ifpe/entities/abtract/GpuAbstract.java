package br.com.ifpe.entities.abtract;

public abstract class GpuAbstract {
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public GpuAbstract() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GpuAbstract(String isbn, String titulo, String autor, int ano) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
