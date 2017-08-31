/**
 * 
 */
package demo1;


import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class demo2 {

	
	public static int[] getEachNum(String str){
		
		int ia[] = new int[str.length()];
	
		for(int i=0;i<str.length();i++){
		   char c = str.charAt(i);//逐个获取字符串中的字符
		    
		}
		
		for(int i=0;i<str.length();i++){
		   char c = str.charAt(i);//逐个获取字符串中的字符
		   ia[i]=(int)(c-'0');//字符数字-字符0就是实际的数字值，赋值给数字数组
		}
		
		return ia;
		
	
	}
	
	
	public static String getAnser(int num){
		
		int []arr={0,1,2,3,4,5,6,7,8,9};
		String []arr1={"零","一","二","三","四","五","六","七","八","九"};
		StringBuilder tmp=new StringBuilder();
		
		
		
		for (int i = 0; i < arr1.length; i++) {
			if (i+1!=arr1.length&&(arr[i+1]+"").equals(num+"")) {
				//System.out.println(arr1[i+1]);
				tmp.append(arr1[i+1]);
				
			}
		}
		return tmp.toString();
		
		
		
	}
	
	
	
	public static void transfor(String []str){
		
		if (str.length<=9) {
			//123 456 789
			//一 亿 二 千三 百 四十五 万 六 千 七 百 八十九
			
		}else{
			
			System.out.println("转换失败！");
			
		}
		
		
		
		
	}
	
	
	public static void Get(){
		Scanner scanner=new Scanner(System.in);
		String inta=scanner.next();
		int []arr=getEachNum(inta);
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(getAnser(arr[i]));
		}
		System.out.println(sb.toString());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Get();
		
		

	}

}
