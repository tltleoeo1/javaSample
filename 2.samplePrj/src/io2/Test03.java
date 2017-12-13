package io2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {
		String fileName = "c://file/data.obj";
		FileOutputStream fos = null; // 출력
		BufferedOutputStream bos = null; // 버퍼링
		ObjectOutputStream oos = null; // 객체저장

		try {
			fos = new FileOutputStream(fileName); // 어펜드모드 false
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos); // 오브젝트를 통과시킴

			Date now = new Date();
			oos.writeObject(now);
			oos.writeObject("java io(object) test");
			oos.flush(); // 버퍼링작업 플러쉬X -> 저장 안됨
			System.out.println(fileName + "에 저장되었습니다.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (bos != null)
					bos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
