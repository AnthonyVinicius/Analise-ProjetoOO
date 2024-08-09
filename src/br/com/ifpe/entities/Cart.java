package br.com.ifpe.entities;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.entities.abstractclass.CpuAbstract;

public class Cart{
    private List<CpuAbstract> items;
    private double totalValue;

    public Cart() {
        this.items = new ArrayList<>();
        this.totalValue = 0.0;
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

    public double getTotalValue() {
        return totalValue;
    }

    public List<CpuAbstract> getItems() {
        return items;
    }
}
