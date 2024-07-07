package br.com.ifpe.main;
import br.com.ifpe.entities.*;

public class Main {
	public static void main(String[] args) {
		Livro livro = new LivroBuilder()
							.isbn("23131231")
							.ano(2020)
							.build();
		
		System.out.println(livro);
	}
}
