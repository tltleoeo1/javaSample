package test.io;

import java.util.ArrayList;

import io.prob.FileCompareUtil;

public class OOOTest {
	public static void main(String[] args) {
		FileCompareUtil util = new FileCompareUtil(); // ��ü����
		try {
			ArrayList<String> data = util.compareFile("c://file/text01.txt ", "c://file/text02.txt ");
			
			System.out.println(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*** MAIN END ***");
	}
}
