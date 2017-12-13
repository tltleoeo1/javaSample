package io; //io작업시 상대주소보다 항상 절대주소를 사용하는 것이 정석이다.

import java.io.File; //탐색기프로그램
import java.util.Arrays;
import java.util.Scanner;

public class FileTest {
	public static void main(String[] args) {
		// Scanner scanner = new Scanner(new File(""));
		File f = new File("c://file/test01.txt");// ->절대주소
		System.out.println(f.exists());// 파일이 있다면 true, 없다면 false

		File dir = new File("c:\\");
		String[] list = dir.list();
		// System.out.println(Arrays.toString(list)); // 배열을 출력할떄 어레이즈투스트링사용

		File file = null;
		for (int i = 0; i < list.length; i++) { // 배열->for루프사용
			file = new File(dir, list[i]);
			System.out.println(file.lastModified());// 날짜정보
			System.out.print(" " + file.getName());
			if (file.isDirectory()) {
				System.out.println(" <dir>");
			}
		}

		System.out.println("*** MAIN END ***");

	}

}
