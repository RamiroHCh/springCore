package com.sanchezih.di.spring.service.impl;

import org.springframework.stereotype.Service;

import com.sanchezih.di.spring.service.Converter;

@Service("arsToUSDConverter")
public class ARSToUSDConverter implements Converter {

	private final double RATE = 138.53;

	public Double convert(Double cantidad) {
		return cantidad * RATE;
	}
}
