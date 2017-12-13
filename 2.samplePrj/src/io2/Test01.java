package io2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;

public class Test01 {
	public static void main(String[] args) {
		String f1 = "c://file/text01.txt";
		String f2 = "c://file/text02.txt";
		String f3 = "c://file/test01.txt";

		FileInputStream fis1 = null, fis2 = null, fis3 = null;
		SequenceInputStream si = null; // 변수 선언, 시퀀스 = 통합
		BufferedInputStream bis = null;

		try {
			fis1 = new FileInputStream(f1);// 객체생성 = 스트림을 열었다.
			fis2 = new FileInputStream(f2);
			fis3 = new FileInputStream(f3);

			si = new SequenceInputStream(fis1, fis2);

			bis = new BufferedInputStream(si);

			int data = 0;
			while (true) {
				data = bis.read();
				if (data == -1)
					break;
				System.out.print((char) data);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (bis != null) {
					bis.close();
					bis = null;
				}
				if (si != null) {
					si.close();
					si = null;
				}
				if (fis1 != null) {
					fis1.close();
					fis1 = null;
				}
				if (fis2 != null) {
					fis2.close();
					fis2 = null;
				}
				if (fis3 != null) {
					fis3.close();
					fis3 = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
