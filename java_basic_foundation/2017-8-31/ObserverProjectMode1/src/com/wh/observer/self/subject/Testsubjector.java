package com.wh.observer.self.subject;

import com.wh.observer.self.object.Observer;

public class Testsubjector {
	
	private static  void TestWeiXing(){
		subjecter subjecter = new subjecter();
		// ����΢���û�
		Observer user1 = new Observer("����");
		Observer user2 = new Observer("����");
		Observer user3 = new Observer("ϰ���");
		// ���Ĺ��ں�
		subjecter.attach(user1);
		subjecter.attach(user2);
		subjecter.attach(user3);
		// ���ںŸ��·�����Ϣ�����ĵ�΢���û�
		subjecter.notifyObject("������ר��������");

	}
	
	public static void main(String[] args) {
		TestWeiXing();
	}

}
