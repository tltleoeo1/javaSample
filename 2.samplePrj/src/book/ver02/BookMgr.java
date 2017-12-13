package book.ver02;

public class BookMgr {
   private int count = 0;
   private Book[] bookList = new Book[100];

   public BookMgr(){}
   public BookMgr(Book[] data) {
      System.arraycopy(data, 0, bookList, count, data.length);
      count = count+data.length;
   }
   //추가기능
   public void addBook(Book data){
	   bookList[count] = data;
	   count++;
   }
   //목록보기기능
   public void printBookList(){
	   for(int i=0;i<count;i++){
		   bookList[i].display();
	   }
   }
   public void printTitleList(){
	   for(int i=0;i<count;i++){
		   System.out.println(bookList[i].getTitle());
	   }
   }
   //기능추가 (검색기능)
   public void searchBookList(String title){
	   int c = 0;
	   for(int i = 0;i<count ; i++){
         if(bookList[i].getTitle().equals(title)){
        	bookList[i].display(); 
        	c++;
         }
	   }
	   if(c==0){
		   System.out.println("요청한도서가없습니다.");
	   }
   }
   //삭제기능추가
   public void delete(String title){ //삭제할 도서를 찾아야한다.
	   for(int i = 0; i<count;i++){
		   if(bookList[i].getTitle().equals(title)){
			   bookList[i].getTitle().equals(title);
			   System.out.println("삭제합니다.:");
			   bookList[i].display();
		       System.arraycopy(bookList, i+1, bookList, i, count-i);
		       count--;
		   break;
		   }
	   
	   }
	   
   }
}
