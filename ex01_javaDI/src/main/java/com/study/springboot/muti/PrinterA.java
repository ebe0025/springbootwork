package com.study.springboot.muti;

public class PrinterA implements Printer {

	@Override
	public void print(String msg) {
		System.out.println("PrinterA : " + msg);

	}

}
