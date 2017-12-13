package won;

public class Pr01 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Test01()); // 噙溯萄儅撩
		Thread t2 = new Thread(new Test02());

		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
	}
}

class Test01 implements Runnable {
	int sum;

	@Override
	public void run() {
		for (int i = 0; i < 10; i = i + 2) {
			sum += i;
			System.out.println("礎熱高 : " + sum);
		}
	}

}

class Test02 implements Runnable {
	int sum;

	@Override
	public void run() {
		for (int i = 1; i < 10; i = i + 2) {
			sum += i;
			System.out.println("�汝鰤� : " + sum);
		}
	}

}