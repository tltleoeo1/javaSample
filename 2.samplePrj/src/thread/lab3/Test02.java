package thread.lab3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Test02 {
	JFrame f = new JFrame("Thread Test"); // JFrame 생성(명시적초기화)
	JButton start = new JButton("start");
	JButton clear = new JButton("Clear");
	JButton exit = new JButton("종료");
	JLabel l1, l2, l3;
	JTextField t1, t2, t3;

	Test02() { // 생성자 메서드
		l1 = new JLabel("홀수합");
		l2 = new JLabel("짝수합");
		l3 = new JLabel("총합");
		t1 = new JTextField("", 40); // 처음에 문자열 없고, 40문자
		t2 = new JTextField("", 40);
		t3 = new JTextField("", 40);
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(3, 2)); // 3열2행 그리드레이아웃으로 바꿈
		p1.add(l1); // 센터 구조 완성!
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		f.add(p1, BorderLayout.NORTH);

		Panel p2 = new Panel();
		p2.add(start);
		p2.add(clear);
		p2.add(exit);
		p2.setBackground(Color.CYAN);
		f.add(p2, BorderLayout.SOUTH);
		// f.add(start, BorderLayout.SOUTH);

		f.setSize(300, 300); // 프레임 사이즈 지정
		f.setVisible(true); // 눈에 보이게 해주는 기능
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스 = 클로우즈

		start.addActionListener(new ActionListener() { // 감시자부착 = 버튼이 눌려지는지 확인
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Thread.currentThread());

				Job1 job1 = new Job1("job1");
				Job2 job2 = new Job2("job2");
				// Thread job1 = new Thread(j1, "job1"); //안해도된다.
				// Thread job2 = new Thread(j2, "job2");
				job1.start();
				job2.start();

				try {
					job1.join();
					job2.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				t3.setText("총합은 : " + (job1.sum + job2.sum)); // 스트링화해야함
			}

		});

		clear.addActionListener(new ActionListener() { // 감시자

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Thread.currentThread());
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
		});

		exit.addActionListener(new ActionListener() { // 감시자
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Thread.currentThread());
				
				f.setVisible(false); // 눈에 안보이게한다.
				f.dispose(); // 했던 작업 파괴
				System.exit(0); // 애플리케이션 종료
			}
		});

	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		new Test02();
	}

	class Job1 extends Thread { // 임플리먼츠 하지않고 익스텐즈 쓰레드
		Job1() { // 디폴트생산자
		}

		Job1(String name) { // 생산자함수
			super(name);
		}

		int sum;

		@Override
		public void run() {
			System.out.println(Thread.currentThread()); // 동작하고 있는 쓰레드정보
			for (int i = 1; i < 10000; i = i + 2) { // 홀수의합
				sum += i;
				// System.out.println("1~" + i + "홀수값의 합은 : " + sum);
				t1.setText("홀수합은 : " + sum);
				// Thread.yield();
			}
		}

	}

	class Job2 extends Thread {
		Job2() { // 디폴트생산자
		}

		Job2(String name) { // 생산자함수
			super(name);
		}

		int sum;

		@Override
		public void run() {
			System.out.println(Thread.currentThread());
			for (int i = 0; i < 10000; i = i + 2) { // 짝수의합
				sum += i;
				// System.out.println("1~" + i + "짝수값의 합은 : " + sum);
				t2.setText("짝수합은 : " + sum);
				// Thread.yield();

			}
		}

	}
} // 이너클라스 작업
