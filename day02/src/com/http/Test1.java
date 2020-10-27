package com.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test1 {

	public static void main(String[] args) { // ������ �����ؼ� ���� ��������
		String urlstr = "http://192.168.0.19/network/Users.jsp";
		URL url = null;
		URLConnection con = null;
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			url = new URL(urlstr);
			con = url.openConnection();
			is = con.getInputStream();
			isr = new InputStreamReader(is, "UTF-8"); // ���ڵ����༭ ���� �� ������ ��
			br = new BufferedReader(isr);
			System.out.println(br);
			
			String str = "";
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
