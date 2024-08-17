package com.study.springboot.muti;

import org.springframework.stereotype.Component;

@Component("printerB")
public class PrinterB implements Printer {

	@Override
	public void print(String msg) {
		System.out.println("PrinterB : " + msg);

	}

}
