package book.ver01;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {
	private String title;
	private int price;

	public Book() {
	} // 생성자함수

	public Book(String title, int price) {
		this.title = title;
		this.setPrice(price);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public void display() {
		System.out.printf("Book[%s : %d원]%n", title, price);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Book o) {
		return price - o.price;
	}

}
