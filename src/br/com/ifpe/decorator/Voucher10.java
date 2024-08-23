package br.com.ifpe.decorator;

import br.com.ifpe.entities.ICart;
import br.com.ifpe.entities.abstractclass.CpuAbstract;

import java.util.List;

public class Voucher10 extends VoucherDecorator {
    public Voucher10(ICart cart) {
        super(cart);
    }

    @Override
    public double getPrice() {
        return super.getPrice() - 10 ;
    }

    @Override
    public void remove(CpuAbstract toRemove) {

    }

    @Override
    public void add(CpuAbstract cpu) {

    }

    @Override
    public List<CpuAbstract> getItems() {
        return List.of();
    }

}