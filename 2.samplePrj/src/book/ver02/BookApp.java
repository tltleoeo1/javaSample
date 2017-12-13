package book.ver02;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		Book[] data = {                                              //배열생성
				       new Book("Servlet", 500),                     
				       new Book("자바프로그래밍", 900), 
				       new Book("SQL",700)
				       };
		
		BookMgr bm = new BookMgr(data);
		Scanner scanner = new Scanner(System.in);
		int cmd = 0;
		while(true){
		System.out.println("====================");
		System.out.println("도서정보프로그램");
		System.out.println("1.목록보기");
		System.out.println("2.도서등록");
		System.out.println("3.도서삭제");
		System.out.println("4.도서검색");
		System.out.println("5.종료");
		System.out.println("====================");
		System.out.println("원하는명령을입력하세요");
		cmd = Integer.parseInt(scanner.nextLine().trim());
		
		switch(cmd){
			case 1:
				bm.printBookList();
				break;
						
			case 2:
				System.out.println("등록할도서제목을입력하세요");
				String title = scanner.nextLine();
				System.out.println("등록할도서가격을입력하세요");
				int price = scanner.nextInt();
				scanner.nextLine();
				Book data1 = new Book(title,price);
				bm.addBook(data1);
				//bm.printBookList();
				System.out.println("등록된 도서정보는 다음과 같습니다.");
				bm.searchBookList(title);
				break;
			case 3:
				System.out.println("삭제작업수행");
				System.out.println("삭제할도서제목을 입력하세요.");
			    title = scanner.nextLine();
				bm.delete(title);
				break;
				
            case 4:
				System.out.println("도서검색기능을수행합니다.");
				System.out.println("검색할도서제목을입력하세요.");
				title = scanner.nextLine();
				bm.searchBookList(title);
				break;
            case 5:
	System.out.println("프로그램을 종료합니다.");
	System.exit(0);
	             break;
	             
	             default:
	            	 System.out.println("다시선택해주세요");
	
		}
				

	}
	}
}
