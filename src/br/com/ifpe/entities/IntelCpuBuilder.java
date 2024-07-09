package br.com.ifpe.entities;

public class IntelCpuBuilder {
	
	public IntelCpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String modelo;
    private String socket;
    private int nucleos;
    private int threads;
    private float hrz;

    public IntelCpuBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public IntelCpuBuilder socket(String socket) {
        this.socket = socket;
        return this;
    }

    public IntelCpuBuilder nucleos(int nucleos) {
        this.nucleos = nucleos;
        return this;
    }

    public IntelCpuBuilder threads(int threads) {
        this.threads = threads;
        return this;
    }

    public IntelCpuBuilder hrz(float hrz) {
        this.hrz = hrz;
        return this;
    }


    public IntelCpu build() {
        return new IntelCpu(modelo, socket, nucleos, threads, hrz);
    }
}
