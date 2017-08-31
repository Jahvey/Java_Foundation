package com.wh.observer.JavaSupportPublisher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Wedding {
	
	private String place;
	private String data;
	
	private String brideName;//ÐÂÄï
	private String bridegroomName;//ÐÂÀÉ
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Wedding(String place, String data) {
		super();
		this.place = place;
		if (dataValidate(data)) {
			this.data = data;
		}
		
	}
	public Wedding(String place, String data, String brideName, String bridegroomName) {
		super();
		this.place = place;
		this.data = data;
		this.brideName = brideName;
		this.bridegroomName = bridegroomName;
	}
	public String getBrideName() {
		return brideName;
	}
	public void setBrideName(String brideName) {
		this.brideName = brideName;
	}
	public String getBridegroomName() {
		return bridegroomName;
	}
	public void setBridegroomName(String bridegroomName) {
		this.bridegroomName = bridegroomName;
	}
	

	public static boolean dataValidate(String data) {
	
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = df.parse(data);
			String string=df.format(date);
			System.out.println(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	
	
	public static void main(String[] args) throws ParseException {
		if (dataValidate("2017-07-03")) {
			System.out.println("success!!");
		}
		

	}
	
	

}
