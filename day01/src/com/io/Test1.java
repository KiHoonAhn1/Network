package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test1 {

	public static void main(String[] args) {
		String file = "c:\\network\\day01\\src\\test.txt"; // 절대 디렉토리를 입력해줘야 함
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); // size는 안 적어서 default로 해도 됨
			fos = new FileOutputStream("test2.txt"); //day01 폴더에 만들어짐
			bos = new BufferedOutputStream(fos);
			int data = 0;
//			while((data=fis.read()) != -1 ) {
			while((data=bis.read()) != -1 ) { // bis가 더 빠르다 (확장 ver)
				bos.write(data);
				System.out.println((char)data); // 한글을 1byte씩 쪼개서 전송하기 때문에 깨진다
			}
			System.out.println(fis.available());
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
