package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Test4 {

	public static void main(String[] args) { // ����, ���Ϸ�, IoT ��ġ���� �ֱ������� server�� ��ġ ���� 
		String urlstr = "http://192.168.0.19/network/login.jsp";
		URL url = null;
		HttpURLConnection con = null; //HttpURLConnection�� UrlConnection���� ����� ���Ƽ� ����
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
				String id = "qqq";
				String pwd = "111";
						url = new URL(urlstr+"?id="+id+"&pwd="+pwd);
 				con = (HttpURLConnection) url.openConnection();
				con.setReadTimeout(5000); //5�� ���� ���� ������ ������ ����
				con.setRequestMethod("POST");
				con.getInputStream();
				
				is = con.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				System.out.println(br);
				
				String str = "";
				while((str = br.readLine()) != null) {
					System.out.println(str.trim());
				}
//			con.connect();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.disconnect();
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
