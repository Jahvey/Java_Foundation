package com.wh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static void SendServer(){
		//SocketServer ss=new SocketServer();
		
		try {
			
			ServerSocket ss=new ServerSocket(9999);
			System.err.println("�����׽���.....");
			
			Socket socket=ss.accept();
			InputStreamReader isr=new InputStreamReader(socket.getInputStream());
			
			BufferedReader br=new BufferedReader(isr);
			String string=br.readLine();
			System.out.println("�������˽��յ���"+string);
			
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
			pw.write("��Ҳ�ã��ͻ�����");
			
			pw.close();
			socket.close();
					
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendServer();

	}

}
