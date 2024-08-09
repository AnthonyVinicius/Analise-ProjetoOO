package br.com.ifpe.decorator;

public class CupomClient extends CupomDecorator {

    @Override
    public double getPrice(double originalPrice) {
        return originalPrice - (originalPrice * 0.10);
    }
}