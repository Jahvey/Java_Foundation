package com.hrr.test;

public class NarcissusNumber {
public static void main(String[] args) {
	System.out.println("水仙花数有：");
	for (int i = 100; i <= 999; i++) {
		//百位
		int h = i /100;
		//十位
		int t = i /100/10;
		//个位
		int b = i % 100 % 10;
		int sum = 0;
		sum  = (int) (Math.pow(h, 3)+ Math.pow(t, 3) + Math.pow(b, 3));
		if (sum==i) {
			System.out.print(i +" ");
		}
	}
}
}
