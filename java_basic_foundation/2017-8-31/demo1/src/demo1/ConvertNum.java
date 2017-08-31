package demo1;

import java.util.Scanner;

public class ConvertNum {
	
	public static String get(){
		// Money用于存放输入的金额数
				long Money = 0;
				// String Mon[]={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

				// int []arr={0,1,2,3,4,5,6,7,8,9};
				String[] arr1 = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
				String arr2[] = { "拾", "佰", "仟", "万", "拾", "百", "仟", "亿", "拾", "百", "仟" }, je[] = new String[30];// je[]数组用于存放数字金额被转换后的数字
				
				// 壹仟万贰百万叁拾万肆万 伍仟陆佰柒拾捌
				// 12345 678
				StringBuilder sb=new StringBuilder();
				System.out.println("请输入需要转换的金额：");
				Scanner sc = new Scanner(System.in);
				Money = Long.parseLong(sc.next());
				// bitt用于存放第几个需转换的金额数字，
				int bitt = 0, j, k = -1, i = 0;
				// 转换过程
				while (Money != 0) {
					bitt = (int) (Money % 10L);
					// 计算出每个数字对应的大写值
					for (j = 0; j < arr1.length; j++) {
						if (j == bitt)
							break;
					}
					// 将相应的值存入je[]中
					if (k != -1) {
						je[i] = arr2[k];
						i++;
					}
					je[i] = arr1[j];
					i++;
					Money = Money / 10;
					k++;
					if (Money == 0) {
						// 输出转换后的金额
						System.out.print("您输入的金额为：");
						i--;
						for (; i >= 0; i--)
							//System.out.print(je[i]);
							sb.append(je[i]);
					}
				}
				return sb.toString();
	}
	
	
	
	public static String regProcessor(String str){
		//String reg="(零[拾佰仟万拾百仟亿拾百仟])+";//一百零七
		String reg="(零[佰拾百仟])+";//一百零七
		str=str.replaceAll(reg, "零");//您输入的金额为：一百零零万零七
		String reg1="(零)+";
		str=str.replaceAll(reg1, "零");
		str=str.replaceAll("零万", "万");
		str=str.replaceAll("零亿", "亿");
		//1000007
		//您输入的金额为：一百零零佰零七
		
		return str;
		
	}
	
	public static void main(String[] args) {
		//reg();
		//System.out.println(get());
		System.out.println(regProcessor(get())+"元");
	}

}
