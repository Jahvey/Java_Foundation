package com.wh.observer.JavaSupport;

public class Test {
	public static void main(String[] args) {
		Watched libingbing = new Watched("������");
	
		Watcher jeckChen=new Watcher("����");
		Watcher jetli=new Watcher("�");
		libingbing.addObserver(jeckChen);
		libingbing.addObserver(jetli);
		libingbing.Married("2017-8-7");
		libingbing.Married("2017-8-9");
		libingbing.deleteObserver(jetli);
		libingbing.Married("2017-8-11");

	}

}
