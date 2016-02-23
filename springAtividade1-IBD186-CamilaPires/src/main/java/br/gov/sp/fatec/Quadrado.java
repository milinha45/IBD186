package br.gov.sp.fatec;

public class Quadrado implements Figura {
	
	private String nome;
	private float lado;
	
	public Quadrado(){
		this.nome = "Quadrado";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getLado() {
		return lado;
	}
	public void setLado(float lado) {
		this.lado = lado;
	}
	
	@Override
	public float calcularArea(){
		return lado*lado;
	}

}
