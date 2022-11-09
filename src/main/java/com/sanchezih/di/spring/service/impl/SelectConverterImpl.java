package com.sanchezih.di.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sanchezih.di.spring.component.Constantes;
import com.sanchezih.di.spring.service.Converter;
import com.sanchezih.di.spring.service.ISelectConverter;

@Service("selectConverter")
public class SelectConverterImpl implements ISelectConverter {

	@Autowired
	@Qualifier("arsToUSDConverter")
	Converter arsToUSDConverter;
	
	@Autowired
	@Qualifier("arsToGBPConverter")
	Converter arsToGBPConverter;
	
	public Converter getTipoConversion(String tareaTipo) {
		if (tareaTipo.equalsIgnoreCase(Constantes.dolares)){
			return arsToUSDConverter;
		}
		
		if (tareaTipo.equalsIgnoreCase(Constantes.libras)){
			return arsToGBPConverter;
		}
		
		return null;
	}

}
