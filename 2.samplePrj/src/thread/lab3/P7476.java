package thread.lab3;

import java.util.Iterator;
import java.util.Map;

public class P7476 {
	public static void main(String[] args) {
		Map map = Thread.getAllStackTraces(); // Map -> 키값 벨류값
		System.out.println(map);
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			Object key = (Object) it.next();
			if (key instanceof Thread) { // key 가 쓰레드 타입이라면
				Thread data = (Thread) key;
				System.out.println(key);
				System.out.print(" damon : " + data.isDaemon());
				System.out.println(" group nme : " + data.getThreadGroup().getName());
			}
		}
	}
}
