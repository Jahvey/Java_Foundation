package com.wh.observer.self.subject;

import com.wh.observer.self.object.Observer;

public class Testsubjector {
	
	private static  void TestWeiXing(){
		subjecter subjecter = new subjecter();
		// 创建微信用户
		Observer user1 = new Observer("刘欢");
		Observer user2 = new Observer("成龙");
		Observer user3 = new Observer("习大大");
		// 订阅公众号
		subjecter.attach(user1);
		subjecter.attach(user2);
		subjecter.attach(user3);
		// 公众号更新发出消息给订阅的微信用户
		subjecter.notifyObject("王豪的专栏更新了");

	}
	
	public static void main(String[] args) {
		TestWeiXing();
	}

}
