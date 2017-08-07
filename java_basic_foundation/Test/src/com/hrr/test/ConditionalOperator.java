package com.hrr.test;

import java.util.Scanner;

public class ConditionalOperator {
public static void main(String[] args) {
	System.out.println("ÇëÊäÈë³É¼¨£º");
	Scanner input = new Scanner(System.in);
	int grade = input.nextInt();
	System.out.println((grade >= 90)?'A':((grade >=60 && grade <= 89)?'B':'C'));
	input.close();
}
}
