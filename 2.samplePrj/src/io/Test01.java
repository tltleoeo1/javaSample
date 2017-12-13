package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) {
		String fileName = "c://file/test01.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(fileName);
			fos = new FileOutputStream("c://file/copy01.txt", false);
			// txt인 경우에 한글문제 ?
			int read = 0;
			while ((read = fis.read()) != -1) {
				System.out.print((char) read);
				fos.write(read);
			}

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
		System.out.println("*** MAIN END ***");
	}
}
