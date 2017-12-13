package won;

public class StckTest {
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);

		Job1 j1 = new Job1(stack);
		Job3 j3 = new Job3(stack);

		Thread job1 = new Thread(j1, "push");
		Thread job3 = new Thread(j3, "pop");

		job1.start(); // 없을땐 뭘까? 싱글쓰레드
		job3.start(); // 멀티쓰레드

		System.out.println("*** MAIN END ***");
	}

}

class Job1 implements Runnable {
	MyStack stack; // MyStack 의 주소를 받는다.

	public Job1() {
	}

	public Job1(MyStack stack) {
		this.stack = stack;
	}

	public MyStack getStack() { // 셋_겟 메서드 -> 교체작업을 하기 위해서
		return stack;
	}

	public void setStack(MyStack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println("push(생산) => " + i);
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
			System.out.println("pop(소비) => " + data);
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

	public synchronized void push(int num) { // 데이터를 넣는다.
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

	public synchronized int pop() { // 데이터를 뺀다.
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
