package com.sanchezih.di.spring;

import java.util.ResourceBundle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sanchezih.di.spring.configuration.SpringConfigurador;
import com.sanchezih.di.spring.service.Converter;
import com.sanchezih.di.spring.service.ISelectConverter;

public class Main {

	public static void main(String[] args) {

 		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpringConfigurador.class);
		applicationContext.refresh();

		ResourceBundle resource = ResourceBundle.getBundle("application");
		
// 		double cantidad = 100;
		double cantidad = Double.parseDouble(resource.getString("cantidad"));
//		Converter c = new ARSToUSDConverter();
 		Converter c = null;
 		Converter c1 = null;

 		//seleccionando conversor
		ISelectConverter selectConverter = ((ISelectConverter) applicationContext.getBean("selectConverter"));

		c = selectConverter.getTipoConversion(resource.getString("dolar"));
		System.out.println(c.convert(cantidad));

		c = selectConverter.getTipoConversion(resource.getString("libra"));
		System.out.println(c.convert(cantidad));
		
		//por bean
		c1 = ((Converter) applicationContext.getBean("arsToUSDConverter"));
		System.out.println(c1.convert(cantidad));
		
		c1 = ((Converter) applicationContext.getBean("arsToGBPConverter"));
		System.out.println(c1.convert(cantidad));
	}
	
}
