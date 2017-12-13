package thread.lab4;

public class AccountTest {
	public static void main(String[] args) {
		System.out.println("*** main start ***");
		Account acc = new Account("홍길동", 1200); // 계좌개설

		Job1 j1 = new Job1(acc); // 통장
		Job1 j2 = new Job1(acc); // 카드

		Thread job1 = new Thread(j1, "카드");
		Thread job2 = new Thread(j2, "통장");

		job1.start();
		job2.start();

		System.out.println("*** main end ***");
	}
}

class Job1 implements Runnable { // 인터페이스이기 때문에 오버라이팅할메서드가 있다(run())
	Account scc;

	Job1() {
	}

	Job1(Account scc) {
		this.scc = scc;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			int money = (int) ((Math.random() * 3 + 1) * 100);
			// if (scc.getMoney() >= money) {
			//System.out.println(Thread.currentThread());
			scc.withdraw(money);
			// }else{
			// System.out.println("잔액부족");
			// System.exit(0);
			// }
		}
	}

}

class Account {
	String name;
	int money;

	public Account() {
	}

	public Account(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", money=" + money + "]";
	}

	public synchronized void withdraw(int money) { // 출금 메서드
		if (this.money >= money) { // 조건
			this.money -= money;
			System.out.println(Thread.currentThread());
			System.out.println("출금 : " + money + " => " + toString());
		} else {
			System.out.println(Thread.currentThread());
			System.out.println("잔액부족");
		}

	}

}