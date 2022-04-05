package com.khan.factory;

import com.khan.model.Printer;

public class PrinterFactory {

	public static Printer getPrinter() {
		return new Printer();
	}
	
}
