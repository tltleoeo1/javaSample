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
		FileOutputStream fos = null; // ���
		BufferedOutputStream bos = null; // ���۸�
		ObjectOutputStream oos = null; // ��ü����

		try {
			fos = new FileOutputStream(fileName); // ������� false
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos); // ������Ʈ�� �����Ŵ

			Date now = new Date();
			oos.writeObject(now);
			oos.writeObject("java io(object) test");
			oos.flush(); // ���۸��۾� �÷���X -> ���� �ȵ�
			System.out.println(fileName + "�� ����Ǿ����ϴ�.");

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
