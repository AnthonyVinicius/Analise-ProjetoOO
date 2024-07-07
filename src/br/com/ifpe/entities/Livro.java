package br.com.ifpe.entities;

public class Livro {
	private String isbn;
	private String titulo;
	private String autor;
	private int ano;
	
	public Livro(String isbn, String titulo, String autor, int ano) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAno() {
		return ano;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Livro [");
	    if (isbn != null) {
	        sb.append("isbn=").append(isbn).append(", ");
	    }
	    if (titulo != null) {
	        sb.append("titulo=").append(titulo).append(", ");
	    }
	    if (autor != null) {
	        sb.append("autor=").append(autor).append(", ");
	    }
	    sb.append("ano=").append(ano);
	    sb.append("]");
	    return sb.toString();
	}
	
}


