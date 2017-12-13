package won;

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1(); // Thread �� �ڼ� Ŭ������ �ν��Ͻ��� ����

		Runnable r = new ThreadEx1_2(); // Runnable �� ������ Ŭ������ �ν��Ͻ��� ����
		Thread t2 = new Thread(r); // ������ Thread (Runnable target)
		// ���� ������ ���ٷ� ������ �����Ѵٸ� -> Thread t2 = new Thread (new ThreadEx1_2());

		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread { // Thread Ŭ������ ���
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); // ������ Thread �� getName() �� ȣ��
		}
	}
}

class ThreadEx1_2 implements Runnable { // Runnable �������̽��� ����

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			// Thread.currentThread() ���� �������� Tread �� ��ȯ�Ѵ�.
			System.out.println(Thread.currentThread().getName());
		}
	}

}