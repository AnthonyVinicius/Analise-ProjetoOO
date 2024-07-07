package br.com.ifpe.services;
import br.com.ifpe.entities.interfaces.InterfaceBiografia;

public class FactoryBiografia implements AbstractFactory <InterfaceBiografia> {

	@Override
	public InterfaceBiografia criar(String tipo) {
		return null;
	}
	
}
