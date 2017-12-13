package thread.lab1;

public class Test03 {

	public static void main(String[] args) {
		System.out.println("*** main start ***");
		System.out.println(Thread.currentThread());

		Job1 j1 = new Job1(); // 러너블한 객체라고 할 수 있다.
		Job2 j2 = new Job2();

		Thread job1 = new Thread(j1, "job1"); // 쓰레드 이름부여
		Thread job2 = new Thread(j2, "job2");

		job1.start();
		job2.start();

		try {
			job1.join();
			job2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("홀수합+짝수합 : " + (j1.sum + j2.sum));

		System.out.println("*** main end ***");

	}

}
