package book.ver01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookMgr {
	private List<Book> bookList = new ArrayList<Book>();
	FileBook file = new FileBook();

	String fileName = "c:/file/book.data";

	public BookMgr() throws FileNotFoundException {

		bookList = (List<Book>) file.read(fileName);

		if (bookList == null || bookList.size() == 0) {
			String fileName = "c:/file/sample1.txt";
			Scanner s = new Scanner(new File(fileName));
			while (s.hasNext()) {
				String readLine = s.nextLine();
				String[] data = readLine.split("/");
				bookList.add(new Book(data[0], Integer.parseInt(data[1].trim())));
			}
		}
		Thread job = new AutoSave();
		job.start();
	}

	public BookMgr(Book[] data) {
		/*
		 * for(int i=0;i<data.length;i++){ bookList.add(data[i]); }
		 */
		List<Book> d = Arrays.asList(data);
		bookList.addAll(d);

		Thread job = new AutoSave();
		job.start();
	}

	// 등록
	public void addBook(Book data) {
		bookList.add(data);
	}

	// 목록보기기능
	public void printBookList() {
		for (int i = 0; i < bookList.size(); i++) {
			bookList.get(i).display();
		}
	}

	public void printTitleList() {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i).getTitle());
		}
	}

	// 기능추가 (검색기능)
	public void searchBookList(String title) {
		int c = 0;

		for (Book data : bookList) {
			if (data.getTitle().equals(title)) {
				data.display();
				c++;
			}
		}
		if (c == 0) {
			System.out.println("요청한도서가없습니다.");
		}
	}

	// 저장기능추가
	public void filesave() {
		file.save(bookList, fileName);

	}

	// 삭제기능추가
	public void delete(String title) {
		Iterator<Book> it = bookList.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			if (book.getTitle().equals(title)) {
				System.out.println("삭제도서정보 : " + book);
				it.remove();
			}
		}
	}

	class AutoSave extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(50000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				file.save(bookList, fileName);
				System.out.println("AutoSave...");
			}
		}
	}

}
