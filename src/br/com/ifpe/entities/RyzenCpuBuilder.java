package br.com.ifpe.entities;

public class RyzenCpuBuilder {
	
	public RyzenCpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String model;
	private String socket;
	private int core;
	private int threads;
	private double hrz;
	private double price;
	
	public RyzenCpuBuilder model(String model) {
		this.model = model;
		return this;
	}
	
	public RyzenCpuBuilder socket(String socket) {
		this.socket = socket;
		return this;
	}
	public RyzenCpuBuilder core(int core) {
		this.core = core;
		return this;
	}
	public RyzenCpuBuilder threads(int threads) {
		this.threads = threads;
		return this;
	}
	public RyzenCpuBuilder hrz(double hrz) {
		this.hrz = hrz;
		return this;
	}
	public RyzenCpuBuilder price(double price) {
		this.price = price;
		return this;
	}
	
	public RyzenCpu build() {
		return new RyzenCpu(model, socket, core, threads, hrz, price);
	}
	
}
