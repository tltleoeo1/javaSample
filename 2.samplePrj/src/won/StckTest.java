package won;

public class StckTest {
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);

		Job1 j1 = new Job1(stack);
		Job3 j3 = new Job3(stack);

		Thread job1 = new Thread(j1, "push");
		Thread job3 = new Thread(j3, "pop");

		job1.start(); // ������ ����? �̱۾�����
		job3.start(); // ��Ƽ������

		System.out.println("*** MAIN END ***");
	}

}

class Job1 implements Runnable {
	MyStack stack; // MyStack �� �ּҸ� �޴´�.

	public Job1() {
	}

	public Job1(MyStack stack) {
		this.stack = stack;
	}

	public MyStack getStack() { // ��_�� �޼��� -> ��ü�۾��� �ϱ� ���ؼ�
		return stack;
	}

	public void setStack(MyStack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println("push(����) => " + i);
		}
	}

}

class Job3 implements Runnable {
	MyStack stack;

	public Job3() {
	}

	public Job3(MyStack stack) {
		this.stack = stack;
	}

	public MyStack getStack() {
		return stack;
	}

	public void setStack(MyStack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int data = stack.pop();
			System.out.println("pop(�Һ�) => " + data);
		}
	}

}

class MyStack {
	int[] list = new int[10];
	int tp = 0;

	public MyStack() {
		super();
	}

	public MyStack(int size) {
		super();
		if (size < 0) {
			list = new int[10];
		} else
			list = new int[size];
	}

	public synchronized void push(int num) { // �����͸� �ִ´�.
		if (tp == list.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list[tp] = num;
		tp++;
		notifyAll();

	}

	public boolean isEmpty() {
		if (tp == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (tp == list.length) {
			return true;
		} else {
			return false;
		}
	}

	public synchronized int top() { //
		if (tp == 0) {
			return -1;
		} else {
			return list[tp - 1];
		}
	}

	public synchronized int pop() { // �����͸� ����.
		if (tp == 0) {
			// return -1;
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		return tp;

	}

}
