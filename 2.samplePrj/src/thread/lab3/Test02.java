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
	JFrame f = new JFrame("Thread Test"); // JFrame ����(������ʱ�ȭ)
	JButton start = new JButton("start");
	JButton clear = new JButton("Clear");
	JButton exit = new JButton("����");
	JLabel l1, l2, l3;
	JTextField t1, t2, t3;

	Test02() { // ������ �޼���
		l1 = new JLabel("Ȧ����");
		l2 = new JLabel("¦����");
		l3 = new JLabel("����");
		t1 = new JTextField("", 40); // ó���� ���ڿ� ����, 40����
		t2 = new JTextField("", 40);
		t3 = new JTextField("", 40);
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(3, 2)); // 3��2�� �׸��巹�̾ƿ����� �ٲ�
		p1.add(l1); // ���� ���� �ϼ�!
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

		f.setSize(300, 300); // ������ ������ ����
		f.setVisible(true); // ���� ���̰� ���ִ� ���
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� = Ŭ�ο���

		start.addActionListener(new ActionListener() { // �����ں��� = ��ư�� ���������� Ȯ��
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Thread.currentThread());

				Job1 job1 = new Job1("job1");
				Job2 job2 = new Job2("job2");
				// Thread job1 = new Thread(j1, "job1"); //���ص��ȴ�.
				// Thread job2 = new Thread(j2, "job2");
				job1.start();
				job2.start();

				try {
					job1.join();
					job2.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				t3.setText("������ : " + (job1.sum + job2.sum)); // ��Ʈ��ȭ�ؾ���
			}

		});

		clear.addActionListener(new ActionListener() { // ������

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Thread.currentThread());
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
		});

		exit.addActionListener(new ActionListener() { // ������
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Thread.currentThread());
				
				f.setVisible(false); // ���� �Ⱥ��̰��Ѵ�.
				f.dispose(); // �ߴ� �۾� �ı�
				System.exit(0); // ���ø����̼� ����
			}
		});

	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		new Test02();
	}

	class Job1 extends Thread { // ���ø����� �����ʰ� �ͽ����� ������
		Job1() { // ����Ʈ������
		}

		Job1(String name) { // �������Լ�
			super(name);
		}

		int sum;

		@Override
		public void run() {
			System.out.println(Thread.currentThread()); // �����ϰ� �ִ� ����������
			for (int i = 1; i < 10000; i = i + 2) { // Ȧ������
				sum += i;
				// System.out.println("1~" + i + "Ȧ������ ���� : " + sum);
				t1.setText("Ȧ������ : " + sum);
				// Thread.yield();
			}
		}

	}

	class Job2 extends Thread {
		Job2() { // ����Ʈ������
		}

		Job2(String name) { // �������Լ�
			super(name);
		}

		int sum;

		@Override
		public void run() {
			System.out.println(Thread.currentThread());
			for (int i = 0; i < 10000; i = i + 2) { // ¦������
				sum += i;
				// System.out.println("1~" + i + "¦������ ���� : " + sum);
				t2.setText("¦������ : " + sum);
				// Thread.yield();

			}
		}

	}
} // �̳�Ŭ�� �۾�
