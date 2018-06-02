package com.method.inject;

public interface LookupI {
	public Printer createPrototypePrinter();  
    public Printer createSingletonPrinter();
    public void sayHello();
}
