package com.bnyw.day27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 获取7位双色球的工具类
 * @author Owen
 *
 */
public class ProduceNumUtil {
	//生成7位数字的双色球方法，由于首位有0，所以只能为String类型的元素
	public static List<String> createNum(){
		//利用set不能放相同元素的特性生产6位不同号码
		Set<String> num=new HashSet<String>();
		Random random=null;
		while(num.size()<6){
			random = new Random();
			int red = 1+random.nextInt(33);//通过随机整数生成器生成号码
			if(red<10){
				num.add("0"+red);//转换成字符串，小于10则首位+0转换成字符串
			}else{
				num.add(""+red);
			}		
		}
		
		List<String> list = new ArrayList<String>();
		//将set中的数字全部转存到list中去
		for(String red:num){
			list.add(red);
		}
		//利用List允许重复元素的特性生成蓝球
		int blue = 1+random.nextInt(16);
		if(blue<10){
			//Appends the specified element to the end of this list (optional operation). 
			list.add("0"+blue);
		}else{
			list.add(""+blue);
		}
		return list;
	}

}
