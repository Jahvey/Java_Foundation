package com.hrr.test;

public class PrimeNumber {
public static void main(String[] args) {
	//�ܵĸ���
	int sum = 0;
	System.out.println("�����У�");
	for (int i = 100; i <= 200; i++) {
		if (i % 2 != 0 && i % Math.sqrt(i) != 0) {
			sum += 1;
			System.out.print(i+ " ");
		}
	}
	
	System.out.println("\n�����ܵ��У�"+sum+"��");
}
}
