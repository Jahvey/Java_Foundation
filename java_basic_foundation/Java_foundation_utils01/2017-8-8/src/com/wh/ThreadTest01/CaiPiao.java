package com.wh.ThreadTest01;

import java.util.Arrays;
import java.util.Random;

public class CaiPiao {
	
	private static String[] redpool = {"01", "02", "03", "04", "05", "06", "07", "08", "09", //
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",//
			"23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33"};

	private static String[] bluepool = {"01", "02", "03", "04", "05", "06", "07",//
			"08", "09", "10", "11", "12", "13", "14", "15", "16"};

	public  static String [] resultball=null;

	

	

	public static String[] getball(String[] red, String[] blue) {
		Random x = new Random();
		resultball=new String[7];
		String[] strred = new String[6];// �洢��ɫ
		String strblue = "";// �洢��ɫ
		int index = 0;// �α�
		for (int i = 0; i < strred.length; i++) {
			index = x.nextInt(33);//set random seeds
			strred[i] = red[index];//
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
		
		return Arrays.toString(getball(redpool, bluepool));
	}

}
