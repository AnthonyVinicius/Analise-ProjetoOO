package br.com.ifpe.entities.abtract;

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
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public int getThreads() {
		return threads;
	}
	public void setThreads(int threads) {
		this.threads = threads;
	}
	public double getHrz() {
		return hrz;
	}
	public void setHrz(double hrz) {
		this.hrz = hrz;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
