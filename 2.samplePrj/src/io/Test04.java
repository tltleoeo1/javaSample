package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) {
		String fileName = "c://file/bEn.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream("c://file/copy.mp3", false);

			int read = 0;
			int count = 0;
			byte[] buffer = new byte[1024 * 1024];// 1�ް���ŭ
			while ((read = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, read);// 0���� read���� �������������X
				count++;
			}
			System.out.println("i/oȽ�� : " + count);

		} catch (FileNotFoundException e) {
			System.out.println(fileName + "�غ��� �ּ���");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // �ڿ��ݳ�
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("����Ϸ�");
		System.out.println("*** MAIN END ***");
	}
}
