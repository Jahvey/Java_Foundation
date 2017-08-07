package com.wh.observer.JavaSupport1;

import java.util.Observable;

/**
 * 
 * ��������
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

	
	//��һ�� ��ʽ�ϵ� ��ֹ ʱ����ĵ�֪ͨ��ʽ��ʹ��boolean���͵ı���
	
	public void NotifyMarriedFirst(String data) {
		if (!data.equals(this.data) && !IsNotify) {
			this.data = data;
			this.setChanged();
			this.notifyObservers();
			IsNotify = true;
		}

	}

	/**
	 * //�ڶ��ַ�ʽ����ʱ���ϵ�֪ͨ
	 * 
	 * ��ޱ�յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣 �������յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣
	 * ��յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣 �����յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣
	 */
	public void NotifyMarried(String data) {

		if (this.data == null)
			setData(data);// ע�������д��������ֱ��д�� setData(data);���ظ�
		/**
		 * ֱ��дsetData(data�����н��); 
		 * ��ޱ�յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣
		 * �������յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣 ��յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣
		 * �����յ������Է�������2016-7-6�Ļʹڼ��մ�Ƶ�������롣 ��ޱ�յ������Է�������2016-7-8�Ļʹڼ��մ�Ƶ�������롣
		 * �������յ������Է�������2016-7-8�Ļʹڼ��մ�Ƶ�������롣 �����յ������Է�������2016-7-8�Ļʹڼ��մ�Ƶ�������롣
		 * ��ޱ�յ������Է�������2016-7-11�Ļʹڼ��մ�Ƶ�������롣
		 * �������յ������Է�������2016-7-11�Ļʹڼ��մ�Ƶ�������롣
		 * �����յ������Է�������2016-7-11�Ļʹڼ��մ�Ƶ�������롣
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
