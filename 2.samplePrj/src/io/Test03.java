package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		String fileName = "c://file/ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream("c://file/copy.mp3", false);

			int read = 0;
			int count = 0;
			byte[] buffer = new byte[fis.available()]; // 파일사이즈만큼
			while ((read = fis.read(buffer)) != -1) {
				fos.write(buffer);
				count++;
			}
			System.out.println("i/o횟수 : " + count);

		} catch (FileNotFoundException e) {
			System.out.println(fileName + "준비해 주세요");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 자원반납
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("복사완료");
		System.out.println("*** MAIN END ***");
	}
}
