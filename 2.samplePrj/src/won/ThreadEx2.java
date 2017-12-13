package won;

public class ThreadEx2 {
	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
	}
}

class ThreadEx2_1 extends Thread {
	public void run() { // 호출스택의 첫 번째 메서드가 main메서드가 아니라 run메서드임을 확인할 수 있다.
		throwException(); // 고의로 예외를 발생을 시킨다.
	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace(); // PrintStackTrace() 를 이용하여 예외가 발생한 당시의 호출스택을
									// 출력
		}
	}
}
// 한 쓰레드가 예외가 발생해서 종료되어도 다른 쓰레드의 실행에는 영향을 미치지 않음을 확인 할 수 있다.