package com.wh.observer.JavaSupport;

public class Test {
	public static void main(String[] args) {
		Watched libingbing = new Watched("·¶±ù±ù");
	
		Watcher jeckChen=new Watcher("³ÉÁú");
		Watcher jetli=new Watcher("Àî³¿");
		libingbing.addObserver(jeckChen);
		libingbing.addObserver(jetli);
		libingbing.Married("2017-8-7");
		libingbing.Married("2017-8-9");
		libingbing.deleteObserver(jetli);
		libingbing.Married("2017-8-11");

	}

}
