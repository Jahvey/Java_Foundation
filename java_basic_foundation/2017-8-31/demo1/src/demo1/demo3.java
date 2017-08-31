package demo1;

import java.util.Scanner;

public class demo3 {
	
	 public static String bytesToHexString(byte[] src){
		 
		 	
	        StringBuilder stringBuilder = new StringBuilder("");
	        if (src == null || src.length <= 0) {
	            return null;
	        }
	        for (int i = 0; i < src.length; i++) {
	            int v = src[i] & 0xFF;
	            String hv = Integer.toHexString(v);
	            if (hv.length() < 2) {
	                stringBuilder.append(0);
	            }
	            stringBuilder.append(hv);
	        }
	        return stringBuilder.toString();
	    }
	 
	 
	 
	
	private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
	   public static byte[] hexStringToBytes(String hexString) {
	        if (hexString == null || hexString.equals("")) {
	            return null;
	        }
	        hexString = hexString.toUpperCase();
	        int length = hexString.length() / 2;
	        char[] hexChars = hexString.toCharArray();
	        byte[] d = new byte[length];
	        for (int i = 0; i < length; i++) {
	            int pos = i * 2;
	            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
	            
	        }
	        return d;
	    }
	
//	
//	/**
//     * 对象转byte
//     * @param obj
//     * @return
//     */
//    private static  byte[] ObjectToByte(Object obj) {  
//        byte[] bytes = null;  
//        try {  
//            // object to bytearray  
//            ByteArrayOutputStream bo = new ByteArrayOutputStream();  
//            ObjectOutputStream oo = new ObjectOutputStream(bo);  
//            oo.writeObject(obj);  
//      
//            bytes = bo.toByteArray(); 
//            System.out.println(bytes.length);
//      
//            bo.close();  
//            oo.close();  
//        } catch (Exception e) {  
//            System.out.println("translation" + e.getMessage());  
//            e.printStackTrace();  
//        }  
//        return bytes;  
//    } 
//    
//    /**
//     * byte转对象
//     * @param bytes
//     * @return
//     */
//    private static Object ByteToObject(byte[] bytes) {
//        Object obj = null;
//        try {
//            // bytearray to object
//            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
//            ObjectInputStream oi = new ObjectInputStream(bi);
//
//            obj = oi.readObject();
//            bi.close();
//            oi.close();
//        } catch (Exception e) {
//            System.out.println("translation" + e.getMessage());
//            e.printStackTrace();
//        }
//        return obj;
//    }
//	
//	
	
	public static void main(String[] args) {
		
		
/**
 * 19170821
25
23
8
33
 * */	
		
		
/*
 * 
 32
23
8
33
20170821
 * */
		System.out.println(hexStringToBytes("20170821").length);
		byte[]arr=hexStringToBytes("20170821");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		
		System.out.println(bytesToHexString(hexStringToBytes("20170821")));
		System.out.println("2016".substring(0, 2).equals("20"));
		
	
		
		
	
	
	}

}
