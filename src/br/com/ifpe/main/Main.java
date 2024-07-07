package br.com.ifpe.main;
import br.com.ifpe.entities.*;

public class Main {
	public static void main(String[] args) {
		Manga manga = MangaBuilder.creatMangaBuilder()
				.titulo("Jujutsu Kaisen")
				.ano(2024)
				.autor("Ge")
				.build();



	}
}
