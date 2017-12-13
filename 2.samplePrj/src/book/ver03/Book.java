package book.ver03;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {

	private String title;
	private int price;
	//transient 

	public Book() {
	} // 생성자함수

	public Book(String title, int price) {
		this.title = title;
		setPrice(price);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			return;
		}
		this.price = price;
	}

	public void display() {
		System.out.printf("Book[%s : %d원]%n", title, price);
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
