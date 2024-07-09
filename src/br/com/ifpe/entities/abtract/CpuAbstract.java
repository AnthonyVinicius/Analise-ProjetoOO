package br.com.ifpe.entities.abtract;

public abstract class CpuAbstract {
	private String modelo;
	private String socket;
	private int nucleos;
	private int threads;
	private float hrz;
	
	public CpuAbstract() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CpuAbstract(String modelo, String socket, int nucleos, int threads, float hrz) {
		super();
		this.modelo = modelo;
		this.socket = socket;
		this.nucleos = nucleos;
		this.threads = threads;
		this.hrz = hrz;
	}



	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public int getNucleos() {
		return nucleos;
	}

	public void setNucleos(int nucleos) {
		this.nucleos = nucleos;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public float getHrz() {
		return hrz;
	}

	public void setHrz(float hrz) {
		this.hrz = hrz;
	}
	
	
}
