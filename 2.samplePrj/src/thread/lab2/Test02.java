package thread.lab2;

import java.awt.BorderLayout;
import java.awt.Button;
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
		f.add(start, BorderLayout.SOUTH);

		f.setSize(300, 300); // 프레임 사이즈 지정
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스 = 클로우즈

		start.addActionListener(new ActionListener() { // 감시자부착
			@Override
			public void actionPerformed(ActionEvent e) {
				Job1 j1 = new Job1();
				Job2 j2 = new Job2();
				Thread job1 = new Thread(j1, "job1");
				Thread job2 = new Thread(j2, "job2");
				job1.start();
				job2.start();

				try {
					job1.join();
					job2.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				t3.setText("총합은 : " + (j1.sum + j2.sum)); // 스트링화해야함
			}

		});

	}

	public static void main(String[] args) {
		new Test02();
	}

	class Job1 implements Runnable {
		int sum;

		@Override
		public void run() {
			System.out.println(Thread.currentThread());
			for (int i = 1; i < 10000; i = i + 2) { // 홀수의합
				sum += i;
				// System.out.println("1~" + i + "홀수값의 합은 : " + sum);
				t1.setText("홀수합은 : " + sum);
				// Thread.yield();
			}
		}

	}

	class Job2 implements Runnable {
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
