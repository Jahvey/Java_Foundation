package com.wh.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class textutil {
	
	/**
	 * 
	 * ���ʹ��javaȥ�����ַ���ǰ��Ŀո�
	 * */
	
	public static String replaceTextFirstBlack(String s){
	    for(int i=0;i<s.length();i++){
	            if(s.charAt(i)!=' '){
	                    s=s.substring(i,s.length());
	                    break;
	             }
	    }
	    return s;
	}
	
	/***
	 * 
	 ȥ����ÿһ����ǰ�漸�����֣�
	 ԭ����
	      196             112<url>http://34567maven.aliyun.com/nexus/content/repositories/central/</url>   
	���	��
	            112<url>http://34567maven.aliyun.com/nexus/content/repositories/central/</url>
	 * */
	
	public static String removeTextFirstNum(String string){
		//System.out.println(replaceTextFirstBlack(string));
		String str=string.trim();
		String newStr = str.replaceAll("^([0-9]+)(\\s?)", "");  
		//^([0-9]+)(\\s?)$
		//System.out.println(string.trim());
		System.out.println(newStr);
		return newStr;
		
	} 
	
	
	
	public static File removeFileTextFirstNum(File InputFile,File OutputFile) throws UnsupportedEncodingException, FileNotFoundException{
		//File f=new File("d:/res.txt");
		try {
			FileInputStream fis=new FileInputStream(InputFile);
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	        BufferedReader br = new BufferedReader(isr);
	        
	        
	        
	      //д�������ַ�ʱ���������������
	        FileOutputStream fos=new FileOutputStream(OutputFile);
	        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
	        BufferedWriter  bw=new BufferedWriter(osw);
	        
	        //��д����
	        //BufferedReader br = new BufferedReader(new InputStreamReader(
	        //        new FileInputStream("E:/1556.txt"), "UTF-8"));
	        String line="";
//	        String[] arrs=null;
	        while ((line=br.readLine())!=null) {
//	            arrs=line.split(",");
//	            System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]);
	        	line=removeTextFirstNum(line);
	        	bw.write(line+"\t\n");
	        	
	        }
	       
	        
	      //��д���£�
	        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
	        //        new FileOutputStream(new File("E:/1556.txt")), "UTF-8"));

//	        for(String arr:arrs){
//	            bw.write(arr+"\t\n");
//	        }
	        
	        br.close();
	        isr.close();
	        fis.close();
	        //ע��رյ��Ⱥ�˳���ȴ򿪵ĺ�رգ���򿪵��ȹر�
	        bw.close();
	        osw.close();
	        fos.close();
	        
	       
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 
		}
		return OutputFile;
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		TextReplaceTextFirstBlack();
	}

	private static void TextReplaceTextFirstBlack() {
		String string="     196             112<url>http://34567maven.aliyun.com/nexus/content/repositories/central/</url>";   
		
		System.out.println(replaceTextFirstBlack(string));
		String str=string.trim();
		String newStr = str.replaceAll("^([0-9]+)(\\s?)", "");  
		//^([0-9]+)(\\s?)$
		System.out.println(string.trim());
		System.out.println(newStr);
		
		try {
			removeFileTextFirstNum(new File("C:/Users/Administrator/Desktop/copy"),new File("d:/res.txt"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
