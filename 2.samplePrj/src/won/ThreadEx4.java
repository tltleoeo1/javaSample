package won;

public class ThreadEx4 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++)
			System.out.printf("%s", new String("-")); // "-"��� new String("-")���
														// ? ����ӵ��� ���� ������ ����
														// Ȯ���� �� �ֱ� ���ؼ�
		System.out.println("�ҿ�ð�1 : " + (System.currentTimeMillis() - startTime));

		for (int i = 0; i < 300; i++)
			System.out.printf("%s", new String("|"));
		System.out.println("�ҿ�ð�2 : " + (System.currentTimeMillis() - startTime));
	}
}
// �ϳ��� ������� �� ���� �۾��� �����ϴ� ��� ���40