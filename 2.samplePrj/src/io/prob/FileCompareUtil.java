package io.prob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileCompareUtil {
	public ArrayList compareFile(String fstFileName, String scdFileName) throws Exception {
		ArrayList<String> list = new ArrayList<>();
		FileReader fis1 = null, fis2 = null; // 두개를 비교하는 작업을 할 것이기 때문에
		BufferedReader bis1 = null, bis2 = null;

		fis1 = new FileReader(fstFileName); // 객체생성
		bis1 = new BufferedReader(fis1);

		fis2 = new FileReader(scdFileName);
		bis2 = new BufferedReader(fis2);

		int line = 0;
		String read1 = null, read2 = null;
		while (true) {
			read1 = bis1.readLine(); // 라인별로 읽기
			read2 = bis2.readLine();
			if (read1 == null || read2 == null) {
				break;
			}
			line++;
			if (!read1.equals(read1)) {
				list.add("Line" + line + read2);
			}
		}

		return list;

	}

	public void fileCopy(String src, String dest) {

	}

	public void fileMerge(String... src) {

	}
}
