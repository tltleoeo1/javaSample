package io2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class P910 {
	public static void main(String[] args) {
		System.out.println("main start");

		try (FileOutputStream fos = new FileOutputStream("c://file/error.txt"); 
			 PrintStream ps = new PrintStream(fos);
		) {
			System.setErr(ps);

			System.out.println("~~~~~~~");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.err.println("파일없음"); // err = 순서보장을 받지 못한다. (랜덤)-스트림이 다르다.

		} catch (Exception e) {

		}

		System.out.println("main end");
	}
}
