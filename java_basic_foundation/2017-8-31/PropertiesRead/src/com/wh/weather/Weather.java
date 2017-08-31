package com.wh.weather;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Weather {

	private Weather() {
	}

	private static Weather weather = new Weather();

	public static Weather getInstance() {

		if (weather == null) {
			weather = new Weather();
		}
		return weather;
	}

	public void getWeather() throws Exception {
		String path = weather.getClass().getClassLoader().getResource("weather.properties").getPath();
		InputStream is = null;
		Properties properties = new Properties();

		is = new FileInputStream(new File(path));
		properties.load(is);
		String status = properties.getProperty("status");
		status=new String(status.getBytes("ISO-8859-1"),"utf-8");
		System.out.println(status);

	}

}
