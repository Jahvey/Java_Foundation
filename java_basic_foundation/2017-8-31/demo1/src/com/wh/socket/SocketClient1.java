package com.wh.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;

public class SocketClient1 {
	
	
	public static void SendClient()throws Exception{
		//ServerSocket ss=new ServerSocket(9999);
		Socket socket=new Socket("localhost", 9999);
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
		pw.write("��ã���������");
		
		
		
		InputStreamReader isr=new InputStreamReader(socket.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String string=br.readLine();
		System.out.println("�ͻ��˶˽��յ���"+string);
		
		
		pw.close();
		socket.close();
				
		
	}
	public static void main(String[] args) {
		try {
			SendClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
