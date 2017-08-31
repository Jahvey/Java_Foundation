package com.hrr.test;

public class PrimeNumber {
public static void main(String[] args) {
	//总的个数
	int sum = 0;
	System.out.println("素数有：");
	for (int i = 100; i <= 200; i++) {
		if (i % 2 != 0 && i % Math.sqrt(i) != 0) {
			sum += 1;
			System.out.print(i+ " ");
		}
	}
	
	System.out.println("\n素数总的有："+sum+"个");
}
}
