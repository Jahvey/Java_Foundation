package com.wh.observer.JavaSupport1;

import java.util.Observable;

/**
 * 
 * 结婚的新人
 */
public class WatchedMarried extends Observable {

	private String name;
	private String data;
	private String place;
	private String MarriedName;
	private boolean IsNotify;

	public String getMarriedName() {
		return MarriedName;
	}

	public void setMarriedName(String marriedName) {
		MarriedName = marriedName;
	}

	public String getName() {
		return name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public WatchedMarried(String name) {
		this.name = name;
	}

	
	//第一种 方式上的 防止 时间更改的通知方式，使用boolean类型的变量
	
	public void NotifyMarriedFirst(String data) {
		if (!data.equals(this.data) && !IsNotify) {
			this.data = data;
			this.setChanged();
			this.notifyObservers();
			IsNotify = true;
		}

	}

	/**
	 * //第二种方式进行时间上的通知
	 * 
	 * 赵薇收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。 黄晓明收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。
	 * 李晨收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。 成龙收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。
	 */
	public void NotifyMarried(String data) {

		if (this.data == null)
			setData(data);// 注意这里的写法，不能直接写成 setData(data);会重复
		/**
		 * 直接写setData(data的运行结果); 
		 * 赵薇收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。
		 * 黄晓明收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。 李晨收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。
		 * 成龙收到了来自范冰冰在2016-7-6的皇冠假日大酒店结婚的邀请。 赵薇收到了来自范冰冰在2016-7-8的皇冠假日大酒店结婚的邀请。
		 * 黄晓明收到了来自范冰冰在2016-7-8的皇冠假日大酒店结婚的邀请。 成龙收到了来自范冰冰在2016-7-8的皇冠假日大酒店结婚的邀请。
		 * 赵薇收到了来自范冰冰在2016-7-11的皇冠假日大酒店结婚的邀请。
		 * 黄晓明收到了来自范冰冰在2016-7-11的皇冠假日大酒店结婚的邀请。
		 * 成龙收到了来自范冰冰在2016-7-11的皇冠假日大酒店结婚的邀请。
		 * 
		 */
		if (data.equals(this.data)) {

			this.setChanged();
			this.notifyObservers();
		}

	}

	public void setData(String data) {
		this.data = data;
	}

}
