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
		String file = "c:\\network\\day01\\src\\test.txt"; // ���� ���丮�� �Է������ ��
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); // size�� �� ��� default�� �ص� ��
			fos = new FileOutputStream("test2.txt"); //day01 ������ �������
			bos = new BufferedOutputStream(fos);
			int data = 0;
//			while((data=fis.read()) != -1 ) {
			while((data=bis.read()) != -1 ) { // bis�� �� ������ (Ȯ�� ver)
				bos.write(data);
				System.out.println((char)data); // �ѱ��� 1byte�� �ɰ��� �����ϱ� ������ ������
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
			} // bis�� bos�� fis, fos�� �����ϱ� ������ �̰͸� close���൵ �ȴ�
		}
	}

}