package thread.lab1;

public class Test02 {
	public static void main(String[] args) {

		System.out.println("**************main start************");
		System.out.println(Thread.currentThread());
		// Thread.yield(); //일드메서드 = 조건적인 양보(실행할것이 없기 때문에 무시)

		Thread job1 = new Thread(new Job1());
		Thread job2 = new Thread(new Job2());

		job1.start();
		try { // 메인이 0.1초 잠을 잘것이다.
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		job2.start();

		System.out.println("**************main end************");
	}
}

class Job1 implements Runnable {
	int sum;

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		for (int i = 1; i < 100; i = i + 2) { // 홀수의합
			sum += i;
			System.out.println("1~" + i + "홀수값의 합은 : " + sum);
			// Thread.yield();
		}
	}

}

class Job2 implements Runnable {
	int sum;

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		for (int i = 0; i < 100; i = i + 2) { // 짝수의합
			sum += i;
			System.out.println("1~" + i + "짝수값의 합은 : " + sum);
			// Thread.yield();
		}
	}

}