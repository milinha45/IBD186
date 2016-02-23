package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
		
		Calculo areaQuad = (Calculo) context.getBean("calculo2");
		areaQuad.mostrarArea();
		Calculo areaTrian = (Calculo) context.getBean("calculo1");
		areaTrian.mostrarArea();
	}
}
