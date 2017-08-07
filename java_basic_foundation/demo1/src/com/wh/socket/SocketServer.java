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
			System.err.println("启动套接字.....");
			
			Socket socket=ss.accept();
			InputStreamReader isr=new InputStreamReader(socket.getInputStream());
			
			BufferedReader br=new BufferedReader(isr);
			String string=br.readLine();
			System.out.println("服务器端接收到："+string);
			
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
			pw.write("你也好，客户器端");
			
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
