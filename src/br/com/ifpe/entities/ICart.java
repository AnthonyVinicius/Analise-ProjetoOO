package br.com.ifpe.entities;

import br.com.ifpe.entities.abstractclass.CpuAbstract;

import java.util.List;

public interface ICart {

    double getPrice();

    void remove(CpuAbstract toRemove);

    void add(CpuAbstract cpu);

    List<CpuAbstract> getItems();
}

