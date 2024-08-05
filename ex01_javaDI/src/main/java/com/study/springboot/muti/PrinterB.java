package com.study.springboot.muti;

public class PrinterB implements Printer {

	@Override
	public void print(String msg) {
		System.out.println("PrinterB : " + msg);

	}

}
