package com.sanchezih.di.spring.service.impl;

import org.springframework.stereotype.Service;

import com.sanchezih.di.spring.service.Converter;

@Service("arsToGBPConverter")
public class ARSToGBPConverter implements Converter {
	
	private final double RATE = 160.90;

	public Double convert(Double cantidad) {
		return cantidad * RATE;
	}

}
