package br.com.ifpe.entities;

public class IntelCpuBuilder {
	
	public IntelCpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String model;
    private String socket;
    private int core;
    private int threads;
    private double hrz;
    private double price;

    public IntelCpuBuilder model(String model) {
        this.model = model;
        return this;
    }

    public IntelCpuBuilder socket(String socket) {
        this.socket = socket;
        return this;
    }

    public IntelCpuBuilder core(int core) {
        this.core = core;
        return this;
    }

    public IntelCpuBuilder threads(int threads) {
        this.threads = threads;
        return this;
    }

    public IntelCpuBuilder hrz(double hrz) {
        this.hrz = hrz;
        return this;
    }
    
    public IntelCpuBuilder price(double price) {
        this.price = price;
        return this;
    }


    public IntelCpu build() {
        return new IntelCpu(model, socket, core, threads, hrz, price);
    }
}
