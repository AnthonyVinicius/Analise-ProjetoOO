package br.com.ifpe.services;

public interface AbstractFactory <T> {
	T criar (String tipo);
}
