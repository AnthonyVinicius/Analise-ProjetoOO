
package br.com.ifpe.decorator;

public class CupomDecorator implements Cupom {

    protected Cupom decoratedCupom;

    public CupomDecorator(Cupom decoratedCupom) {
        this.decoratedCupom = decoratedCupom;
    }

    @Override
    public double getPrice(double originalPrice) {
        return decoratedCupom.getPrice(originalPrice);
    }
}

