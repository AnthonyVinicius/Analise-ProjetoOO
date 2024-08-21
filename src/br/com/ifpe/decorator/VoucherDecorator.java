package br.com.ifpe.decorator;

import br.com.ifpe.entities.ICart;

public abstract class VoucherDecorator implements ICart {
    private final ICart cartDecorator;

    public VoucherDecorator(ICart cart) {
       this.cartDecorator = cart;
    }

    @Override
    public double getPrice() {
        return this.cartDecorator.getPrice();
    }
}

