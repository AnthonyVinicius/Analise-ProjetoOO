package br.com.ifpe.entities;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.entities.abstractclass.CpuAbstract;
import br.com.ifpe.utils.Logger;

public class Cart implements ICart {
    private final List<CpuAbstract> items;
    private double totalValue;

    public Cart() {
        this.items = new ArrayList<>();
        this.totalValue = 0.0;
    }

    @Override
    public double getPrice() {
        return totalValue;
    }

    public void add(CpuAbstract cpu) {
        items.add(cpu);
        totalValue += cpu.getPrice();
    }

    public void remove(CpuAbstract cpu) {
        if (items.remove(cpu)) {
            totalValue -= cpu.getPrice();
        }
    }

    public List<CpuAbstract> getItems() {
        Logger.info("Get Items in cart");
        return items;
    }

    @Override
    public String toString() {
        return "Purchase History" + "\nCpus: " + items;
    }
}
