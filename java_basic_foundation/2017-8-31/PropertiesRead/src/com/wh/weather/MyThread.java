package com.wh.weather;

public class MyThread implements Runnable {

	@Override
	public void run() {
		Weather weather=Weather.getInstance();
		try {
			weather.getWeather();
			System.out.println(weather);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

}
