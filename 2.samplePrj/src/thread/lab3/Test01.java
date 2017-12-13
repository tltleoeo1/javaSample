package thread.lab3;

public class Test01 {
	public static void main(String[] args) {
		Job1 job1 = new Job1();
		Job2 job2 = new Job2();

		job1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		job2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ÃÑÇÕ" + (job1.sum+job2.sum));
	}
}

class Job1 extends Thread {
	int sum;

	public void run() {
		for (int i = 1; i < 10; i = i + 2) {
			sum += i;
			System.out.println("È¦¼öÇÕ" + sum);
		}
	}
}

class Job2 extends Thread {
	int sum;

	public void run() {
		for (int i = 0; i < 10; i = i + 2) {
			sum += i;
			System.out.println("Â¦¼öÇÕ" + sum);
		}
	}
}