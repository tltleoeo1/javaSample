package io2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test04 {
	public static void main(String[] args) {
		String fileName = "c://file/data.obj";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(fileName + " : READ");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
