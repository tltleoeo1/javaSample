package io2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class P911 {
	public static void main(String[] args) {
		String fileName = "c://file/err.log";
		FileOutputStream fos = null;
		PrintStream ps = null;

		try {
			fos = new FileOutputStream(fileName, true); // log는 쌓이게 만들 것이므로
														// true옵션
			ps = new PrintStream(fos);
			System.setErr(ps);
			String name = null;
			System.out.println(5/0);

		} catch (Exception e) {
			System.err.print(new Date());
			System.err.print("P911 class에서");
			System.err.print(e.getMessage()+"\r\n");
			System.out.print(e.getMessage()+"\r\n");

		} finally {
			try {
				if (ps != null)
					ps.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("*** MAIN END ***");
	}
}
