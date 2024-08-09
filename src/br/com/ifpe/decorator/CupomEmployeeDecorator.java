package br.com.ifpe.decorator;

public class CupomEmployeeDecorator extends CupomDecorator {

    public CupomEmployeeDecorator(Cupom decoratedCupom) {
        super(decoratedCupom);
    }

    @Override
    public double getPrice(double originalPrice) {
        double discountedPrice = super.getPrice(originalPrice);
        return discountedPrice - (discountedPrice * 0.25);
    }
}