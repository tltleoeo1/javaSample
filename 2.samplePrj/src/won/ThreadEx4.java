package won;

public class ThreadEx4 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++)
			System.out.printf("%s", new String("-")); // "-"대신 new String("-")사용
														// ? 수행속도를 늦춰 측정을 쉽게
														// 확인할 수 있기 위해서
		System.out.println("소요시간1 : " + (System.currentTimeMillis() - startTime));

		for (int i = 0; i < 300; i++)
			System.out.printf("%s", new String("|"));
		System.out.println("소요시간2 : " + (System.currentTimeMillis() - startTime));
	}
}
// 하나의 쓰레드로 두 개의 작업을 수행하는 경우 평균40