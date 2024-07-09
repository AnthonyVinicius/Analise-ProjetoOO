package br.com.ifpe.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ifpe.entities.abtract.CpuAbstract;

public class CpuDAO implements GenericDAO<CpuAbstract, String> {
    private static CpuDAO instancia;
    private Map<String, CpuAbstract> cpus;

    private CpuDAO() {
        cpus = new HashMap<>();
    }

    public static synchronized CpuDAO getInstance() {
        if (instancia == null) {
            instancia = new CpuDAO();
        }
        return instancia;
    }

    @Override
    public void salvar(CpuAbstract cpu) {
        cpus.put(cpu.getModelo(), cpu);
        System.out.println("Salvando CPU: " + cpu.getModelo());
    }

    @Override
    public CpuAbstract buscar(String modelo) {
        return cpus.get(modelo);
    }

    @Override
    public void remover(String modelo) {
        cpus.remove(modelo);
    }

    @Override
    public List<CpuAbstract> listarTodos() {
        return new ArrayList<>(cpus.values());
    }
}