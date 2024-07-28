package br.com.ifpe.services;

import br.com.ifpe.persistence.GenericDAO;

public class DAOFactory {
	public static <T> GenericDAO<T> createDAO(){
		return new GenericDAO<>();
	}
}
