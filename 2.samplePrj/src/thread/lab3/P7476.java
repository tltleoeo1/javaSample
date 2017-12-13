package thread.lab3;

import java.util.Iterator;
import java.util.Map;

public class P7476 {
	public static void main(String[] args) {
		Map map = Thread.getAllStackTraces(); // Map -> Ű�� ������
		System.out.println(map);
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Object key = (Object) it.next();
			if (key instanceof Thread) { // key �� ������ Ÿ���̶��
				Thread data = (Thread) key;
				System.out.println(key);
				System.out.print(" damon : " + data.isDaemon());
				System.out.println(" group nme : " + data.getThreadGroup().getName());
			}
		}
	}
}
