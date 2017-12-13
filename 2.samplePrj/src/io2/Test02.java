package io2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test02 {
	public static void main(String[] args) {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String read = null;
		try {
			while (true) {
				System.out.println("입력하세요_");
				read = br.readLine();
				if ((read.equals(""))) // 빠져나오는 방법
					break;
				System.out.println("input data : " + read);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (ir != null)
					ir.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
