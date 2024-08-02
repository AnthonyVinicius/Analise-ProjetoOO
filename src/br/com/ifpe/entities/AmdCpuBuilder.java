package br.com.ifpe.entities;

public class AmdCpuBuilder {
	
	public AmdCpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String model;
	private String socket;
	private int core;
	private int threads;
	private double hrz;
	private double price;
	
	public AmdCpuBuilder model(String model) {
		this.model = model;
		return this;
	}
	
	public AmdCpuBuilder socket(String socket) {
		this.socket = socket;
		return this;
	}
	public AmdCpuBuilder core(int core) {
		this.core = core;
		return this;
	}
	public AmdCpuBuilder threads(int threads) {
		this.threads = threads;
		return this;
	}
	public AmdCpuBuilder hrz(double hrz) {
		this.hrz = hrz;
		return this;
	}
	public AmdCpuBuilder price(double price) {
		this.price = price;
		return this;
	}
	
	public AmdCpu build() {
		return new AmdCpu(model, socket, core, threads, hrz, price);
	}
	
}
