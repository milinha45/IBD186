package br.gov.sp.fatec;

public class Triangulo implements Figura {
	
	private String nome;
	private float altura;
	private float base;

	public Triangulo (){
		this.nome="Triangulo";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	
	@Override
	public float calcularArea(){
		return (altura*base)/2;
	}

}
