package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test07 {
	public static void main(String[] args) {
		String fileName = "c://file/test01.txt";
		String copyName = "c://file/copy01.txt";

		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			fw = new FileWriter(copyName, false);
			bw = new BufferedWriter(fw);

			int read = 0;
			int count = 0;
			while ((read = br.read()) != -1) {
				System.out.print((char) read);
				bw.write(read);
				count++;
			}

			bw.flush(); // 버퍼비우기
			System.out.println("i/o 횟수 : " + count);

		} catch (FileNotFoundException e) {
			System.out.println(fileName + "준비해주세요");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (fr != null)
					fr.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("*** main end ***");
	}
}
