package com.bnyw.day27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * ��ȡ7λ˫ɫ��Ĺ�����
 * @author Owen
 *
 */
public class ProduceNumUtil {
	//����7λ���ֵ�˫ɫ�򷽷���������λ��0������ֻ��ΪString���͵�Ԫ��
	public static List<String> createNum(){
		//����set���ܷ���ͬԪ�ص���������6λ��ͬ����
		Set<String> num=new HashSet<String>();
		Random random=null;
		while(num.size()<6){
			random = new Random();
			int red = 1+random.nextInt(33);//ͨ������������������ɺ���
			if(red<10){
				num.add("0"+red);//ת�����ַ�����С��10����λ+0ת�����ַ���
			}else{
				num.add(""+red);
			}		
		}
		
		List<String> list = new ArrayList<String>();
		//��set�е�����ȫ��ת�浽list��ȥ
		for(String red:num){
			list.add(red);
		}
		//����List�����ظ�Ԫ�ص�������������
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
