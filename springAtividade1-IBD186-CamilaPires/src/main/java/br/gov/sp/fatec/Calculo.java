package br.gov.sp.fatec;

public class Calculo {
	
	private Figura figuraGeometrica;
	
	public Calculo(){
		
	}

		
	public void mostrarArea(){
		String nome = figuraGeometrica.getNome();
		System.out.println("O valor da area do "+nome+" e: "+figuraGeometrica.calcularArea());
		
	}

	public void setFiguraGeometrica(Figura figuraGeometrica) {
		this.figuraGeometrica = figuraGeometrica;
	}
	
	
}
