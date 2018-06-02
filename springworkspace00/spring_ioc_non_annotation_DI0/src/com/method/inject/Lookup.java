package com.method.inject;

public abstract class Lookup implements LookupI {
	private Printer printer;

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	@Override
	public abstract Printer createPrototypePrinter();

	@Override
	public Printer createSingletonPrinter() {
		System.out.println("该方法不会被执行，如果输出就错了");
		return new Printer();
	}

	@Override
	public void sayHello() {
		printer.print("setter");
		createPrototypePrinter().print("prototype");
		createSingletonPrinter().print("singleton");
	}

}
