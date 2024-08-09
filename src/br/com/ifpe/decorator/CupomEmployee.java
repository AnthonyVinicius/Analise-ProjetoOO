package br.com.ifpe.decorator;

public class CupomEmployee {
    protected CupomEmployee cupomEmployee;

    public CupomEmployee(CupomEmployee cupomEmployee) {
        this.cupomEmployee = cupomEmployee;
    }

    public double getPrice(){
        return (this.getPrice() * 0.25) - this.getPrice();
    }
}
