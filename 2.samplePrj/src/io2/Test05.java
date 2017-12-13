package io2;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test05 {
	public static void main(String[] args) {
		String fileName = "c://file/data2.obj";
		FileOutputStream fos = null; // 출력
		BufferedOutputStream bos = null; // 버퍼링
		ObjectOutputStream oos = null; // 객체저장

		try {
			fos = new FileOutputStream(fileName); // 어펜드모드 false
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos); // 오브젝트를 통과시킴

			// object write 작업(저장)
			Employee emp1 = new Employee("홍길동", "기획부", "900511-000000");
			oos.writeObject(emp1);
			
			List<Employee> list = new ArrayList<>();
			list.add(new Employee("고1", "총무팀", "999999-999999"));
			list.add(new Employee("고2", "총무팀", "999999-999999"));
			list.add(new Employee("고3", "총무팀", "999999-999999"));
			list.add(new Employee("고4", "총무팀", "999999-999999"));
			
			oos.writeObject(list);
			
			oos.flush();

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

class Employee implements Serializable {
	String name; // 이름
	String dept; // 부서
	transient String ssn; // 주민번호

	public Employee() {
	}

	public Employee(String name, String dept, String ssn) {
		this.name = name;
		this.dept = dept;
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", ssn=" + ssn + "]";
	}

}
