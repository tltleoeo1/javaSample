package won;

public class ThreadEx2 {
	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
	}
}

class ThreadEx2_1 extends Thread {
	public void run() { // ȣ�⽺���� ù ��° �޼��尡 main�޼��尡 �ƴ϶� run�޼������� Ȯ���� �� �ִ�.
		throwException(); // ���Ƿ� ���ܸ� �߻��� ��Ų��.
	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace(); // PrintStackTrace() �� �̿��Ͽ� ���ܰ� �߻��� ����� ȣ�⽺����
									// ���
		}
	}
}
// �� �����尡 ���ܰ� �߻��ؼ� ����Ǿ �ٸ� �������� ���࿡�� ������ ��ġ�� ������ Ȯ�� �� �� �ִ�.