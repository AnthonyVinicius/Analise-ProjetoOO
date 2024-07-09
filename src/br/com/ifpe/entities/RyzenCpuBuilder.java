package br.com.ifpe.entities;

public class RyzenCpuBuilder {
	
	private RyzenCpuBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private String modelo;
	private String socket;
	private int nucleos;
	private int threads;
	private float hrz;
	
	public RyzenCpuBuilder modelo(String modelo) {
		this.modelo = modelo;
		return this;
	}
	
	public RyzenCpuBuilder socket(String socket) {
		this.socket = socket;
		return this;
	}
	public RyzenCpuBuilder nucleos(int nucleos) {
		this.nucleos = nucleos;
		return this;
	}
	public RyzenCpuBuilder threads(int threads) {
		this.threads = threads;
		return this;
	}
	public RyzenCpuBuilder hrz(float hrz) {
		this.hrz = hrz;
		return this;
	}
	
	public RyzenCpu build() {
		return new RyzenCpu(modelo, socket, nucleos, threads, hrz);
	}
	
	public static RyzenCpuBuilder creatMangaBuilder(){
		return new RyzenCpuBuilder();
	}
	
}
