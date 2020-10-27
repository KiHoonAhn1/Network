package com.http;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Test3 {

	public static void main(String[] args) { // 차량, 보일러, IoT 장치에서 주기적으로 server에 위치 정보 
		String urlstr = "http://192.168.0.19/network/car.jsp";
		URL url = null;
		HttpURLConnection con = null; //HttpURLConnection이 UrlConnection보다 기능이 많아서 좋다
		Random r = new Random();
		while(true) {
			try {
//				double lat = (r.nextInt(15000)+1)/100;
//				double lng = (r.nextInt(5000)+1)/100;
				
				double lat = Math.random()*90+1;
				double lng = Math.random()*90+1;
				
//			double lat = 127.32;
//			double lng = 37.2;
						url = new URL(urlstr+"?lat="+lat+"&lng="+lng);
				con = (HttpURLConnection) url.openConnection();
				con.setReadTimeout(5000); //5초 동안 답이 없으면 서버가 죽음
				con.setRequestMethod("POST");
				con.getInputStream();
//			con.connect();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.disconnect();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
