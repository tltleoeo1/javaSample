package won;

public class Prob1 {
	public static void main(String[] args) {
		MyStack2 stack = new MyStack2(10);
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		
		
		Job2 j1 = new Job2(stack);
		Job2 j2 = new Job2(stack);

		Thread job1 = new Thread(j1, "j1 Thread");
		Thread job2 = new Thread(j2, "j2 Thread");

		job1.start();
		job2.start();
			
	}

	

}

class Job2 implements Runnable {
	MyStack2 mt;

	Job2() {
	}

	public Job2(MyStack2 mt) {
		this.mt = mt;
	}

	@Override
	public void run() {
		
		mt.top();
		mt.pop();
		mt.pop();
		mt.pop();
		mt.pop();
		mt.pop();
		mt.pop();

	}

}



class  MyStack2 {
	int[] list = new int[10];
	int tp = 0;

	public MyStack2() {
		super();
	}

	public MyStack2(int size) {
		super();
		if (size < 0) {
			list = new int[10];
		} else
			list = new int[size];
	}

	public synchronized void push(int num) { // 데이터를 넣는다.
		list[tp] = num;
		tp++;
		System.out.println(num + "\t\t ----> "+ (Thread.currentThread()));

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
			System.out.println("stack이 비었습니다."+ "\t\t ----> "+ (Thread.currentThread()));
			return -1;
		} else {
			System.out.println("최상위 데이터 :" + list[tp - 1] +"\t\t ----> "+ (Thread.currentThread()));
			return list[tp - 1];
		}
		
	}

	public synchronized int pop() { // 데이터를 뺀다.
		if (tp == 0) {
			System.out.println("stack이 비었습니다." + "\t\t ----> "+ (Thread.currentThread()));
			return -1;
		} else {
			
			tp--;
			System.out.println(list[tp]+"를 빼냈습니다." + "\t\t ----> "+ (Thread.currentThread()));
			return list[tp];
		}

	}
}
