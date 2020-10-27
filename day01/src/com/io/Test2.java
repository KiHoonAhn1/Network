package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Test2 {

	public static void main(String[] args) {
		String file = "c:\\network\\day01\\src\\test.txt"; // 절대 디렉토리를 입력해줘야 함
		FileReader fis = null;
		BufferedReader bis = null;
		FileWriter fos = null;
		BufferedWriter bos = null;
		try {
			fis = new FileReader(file);
			bis = new BufferedReader(fis); // size는 안 적어서 default로 해도 됨
			fos = new FileWriter("test2.txt"); //day01 폴더에 만들어짐
			bos = new BufferedWriter(fos);
			String data = "";
//			while((data=fis.read()) != -1 ) {
			while((data=bis.readLine()) != null ) { // bis가 더 빠르다 (확장 ver) //readLine : 한 line씩 읽음
				fos.write(data);
				System.out.println(data);
			}
//			System.out.println(fis.available());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // bis와 bos는 fis, fos를 포함하기 때문에 이것만 close해줘도 된다
		}
	}

}
