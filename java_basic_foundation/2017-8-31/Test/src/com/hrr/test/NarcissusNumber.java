package com.hrr.test;

public class NarcissusNumber {
public static void main(String[] args) {
	System.out.println("ˮ�ɻ����У�");
	for (int i = 100; i <= 999; i++) {
		//��λ
		int h = i /100;
		//ʮλ
		int t = i /100/10;
		//��λ
		int b = i % 100 % 10;
		int sum = 0;
		sum  = (int) (Math.pow(h, 3)+ Math.pow(t, 3) + Math.pow(b, 3));
		if (sum==i) {
			System.out.print(i +" ");
		}
	}
}
}
