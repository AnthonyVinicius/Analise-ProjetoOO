package br.com.ifpe.entities;

public class CupomClient {

    protected CupomClient cupomClient;

    public CupomClient(CupomClient cupomClient) {
        this.cupomClient = cupomClient;
    }

    public double getPrice(){
        return (this.getPrice() * 0.10) - this.getPrice();
    }
}
