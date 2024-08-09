package br.com.ifpe.decorator;

public class CupomClientDecorator extends CupomDecorator {

    public CupomClientDecorator(Cupom decoratedCupom) {
        super(decoratedCupom);
    }

    @Override
    public double getPrice(double originalPrice) {
        double discountedPrice = super.getPrice(originalPrice);
        return discountedPrice - (discountedPrice * 0.10);
    }
}
