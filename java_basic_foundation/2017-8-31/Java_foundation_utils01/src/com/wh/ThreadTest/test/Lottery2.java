package com.wh.ThreadTest.test;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * ��Ʊ������
 */
public class Lottery2 {
	private static int[] redpool = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 16, 27,
			28, 29, 30, 31, 32, 33 };
	private static int[] bluepool = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
	public  static int [] resultball=null;
	public Lottery2() {
		 // ���� 1-33ȡ��6��
		 // ����1-16 ȡһ��
		 // �������һ��˫ɫ����룺
		 // String[] redpool ={"01","02","03"};
		//getball(redpool, bluepool);
	}
	

	

	public static int[] getball(int[] red, int[] blue) {
		Random x = new Random();
		resultball=new int[7];
		int[] strred = new int[6];// �洢��ɫ
		int strblue = 0;// �洢��ɫ
		int index = 0;// �α�
		for (int i = 0; i < strred.length; i++) {
			index = x.nextInt(33);//set random seeds
			strred[i] = red[index];///////
			for (int j = 0; j < i; j++) {
				if (strred[j] == red[index]) {
					//System.out.println("double:" + red[index] + " delete");
					i--;
					break;
				}
			}
		}
		int index2 = x.nextInt(16);
		strblue = blue[index2];
		//System.out.print("��ɫ��Ϊ" + Arrays.toString(strred));
		
		//System.out.println("��ɫ��Ϊ" + strblue);
		//resultball=strred;
		System.arraycopy(strred,0,resultball,0,6);
		resultball[resultball.length-1]=strblue;
		//System.out.println("˫ɫ��齱���Ϊ��"+Arrays.toString(resultball));
		return resultball;
	}

	public static String getResult(){
		
		resultball=getball(redpool, bluepool);
		StringBuilder sb=new StringBuilder();
		sb.append("[");

		for (int i = 0; i < resultball.length; i++) {
			//System.out.print(resultball[i]+",");
		}
		sb.append("]");
		return Arrays.toString(resultball);
	}
	

	public static void main(String[] args) {
		getball(redpool, bluepool);
		
		TextgetString();
	}




	private static void TextgetString() {
		String arr[]=new String[16];
		for (int i = 0; i < arr.length; i++) {
			if (i<9) {
				arr[i]="0"+(i+1);
			}else{
				arr[i]=(i+1)+"";
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println(getString(arr));
	}
	
	
	
	/**
	 * 
	 ���н����
	 ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",//
	  "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", 
	  "25", "26", "27", "28", "29", "30", "31", "32", "33"]

	 * */
	
	 public static String getString1(Object[] a) {
	        if (a == null)
	            return "null";

	        int iMax = a.length - 1;
	        if (iMax == -1)
	            return "[]";

	        StringBuilder b = new StringBuilder();
	        b.append('[');
	        for (int i = 0; ; i++) {
	        	b.append("\"");
	            b.append(String.valueOf(a[i]));
	            if (i == iMax)
	                return b.append("\"").append(']').toString();
	            b.append("\"");
	            b.append(", ");
	        }
	    }

	 
	 
	 public static String getString(Object[] a) {
	        if (a == null)
	            return "null";

	        int iMax = a.length - 1;
	        if (iMax == -1)
	            return "{}";

	        StringBuilder b = new StringBuilder();
	        b.append('{');
	        for (int i = 0; ; i++) {
	        	b.append("\"");
	            b.append(String.valueOf(a[i]));
	            if (i == iMax)
	                return b.append("\"").append('}').append(";").toString();
	            b.append("\"");
	            b.append(", ");
	        }
	    }
}
