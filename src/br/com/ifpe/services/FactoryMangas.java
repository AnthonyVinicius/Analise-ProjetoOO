package br.com.ifpe.services;

import br.com.ifpe.entities.interfaces.InterfaceManga;

public class FactoryMangas implements AbstractFactory<InterfaceManga> {

	@Override
	public InterfaceManga criar(String tipo) {
		return null;
	}
	
}
