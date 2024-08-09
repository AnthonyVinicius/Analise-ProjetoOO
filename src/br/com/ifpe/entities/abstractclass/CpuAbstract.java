package br.com.ifpe.entities.abstractclass;

public abstract class CpuAbstract{
	private String model;
	private String socket;
	private int core;
	private int threads;
	private double hrz;
	private double price;
	
	public CpuAbstract() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CpuAbstract(String model, String socket, int core, int threads, double hrz, double price) {
		super();
		this.model = model;
		this.socket = socket;
		this.core = core;
		this.threads = threads;
		this.hrz = hrz;
		this.price = price;
	}


	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSocket() {
		return socket;
	}

	public int getCore() {
		return core;
	}

	public int getThreads() {
		return threads;
	}

	public double getHrz() {
		return hrz;
	}

	public double getPrice() {
		return price;
	}

	
	
}
