package br.com.ifpe.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ifpe.entities.Livro;

public class LivroDAO implements GenericDAO<Livro, String> {
	private static LivroDAO instancia;
	private Map<String, Livro> livros;
	
	private LivroDAO() {
        livros = new HashMap<>();
    }
	
	public static synchronized LivroDAO getInstance() {
		if (instancia == null) {
			instancia = new LivroDAO();
		}
		return instancia;
	}

	@Override
	public void salvar(Livro livro) {
		livros.put(livro.getIsbn(), livro);
		System.out.println("salvando livro");
	}

	@Override
	public Livro buscar(String titulo) {
		return livros.get(titulo);
	}

	@Override
	public void remover(String isbn) {
		livros.remove(isbn);
		
	}

	@Override
	public List<Livro> listarTodos() {
		return new ArrayList<>(livros.values());
	}
	
}
