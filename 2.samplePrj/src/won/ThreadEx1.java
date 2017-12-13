package won;

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1(); // Thread 의 자손 클래스의 인스턴스를 생성

		Runnable r = new ThreadEx1_2(); // Runnable 을 구현한 클래스의 인스턴스를 생성
		Thread t2 = new Thread(r); // 생성자 Thread (Runnable target)
		// 위의 두줄을 한줄로 간단히 정리한다면 -> Thread t2 = new Thread (new ThreadEx1_2());

		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread { // Thread 클래스를 상속
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName()); // 조상인 Thread 의 getName() 을 호출
		}
	}
}

class ThreadEx1_2 implements Runnable { // Runnable 인터페이스를 구현

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			// Thread.currentThread() 현재 실행중인 Tread 를 반환한다.
			System.out.println(Thread.currentThread().getName());
		}
	}

}