package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		String fileName = "c://file/bEn.mp3";
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);

			fos = new FileOutputStream("c://file/copy.mp3", false);
			bos = new BufferedOutputStream(fos);

			int read = 0;
			int count = 0;
			while ((read = bis.read()) != -1) {
				bos.write(read);
				count++;
			}
			bos.flush();	//플러쉬를 사용하지 않으면 맨뒤가 남는다.
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
