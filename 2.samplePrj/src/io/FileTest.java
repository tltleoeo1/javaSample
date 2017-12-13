package io; //io�۾��� ����ּҺ��� �׻� �����ּҸ� ����ϴ� ���� �����̴�.

import java.io.File; //Ž�������α׷�
import java.util.Arrays;
import java.util.Scanner;

public class FileTest {
	public static void main(String[] args) {
		// Scanner scanner = new Scanner(new File(""));
		File f = new File("c://file/test01.txt");// ->�����ּ�
		System.out.println(f.exists());// ������ �ִٸ� true, ���ٸ� false

		File dir = new File("c:\\");
		String[] list = dir.list();
		// System.out.println(Arrays.toString(list)); // �迭�� ����ҋ� ���������Ʈ�����

		File file = null;
		for (int i = 0; i < list.length; i++) { // �迭->for�������
			file = new File(dir, list[i]);
			System.out.println(file.lastModified());// ��¥����
			System.out.print(" " + file.getName());
			if (file.isDirectory()) {
				System.out.println(" <dir>");
			}
		}

		System.out.println("*** MAIN END ***");

	}

}
