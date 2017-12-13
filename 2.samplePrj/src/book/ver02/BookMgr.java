package book.ver02;

public class BookMgr {
   private int count = 0;
   private Book[] bookList = new Book[100];

   public BookMgr(){}
   public BookMgr(Book[] data) {
      System.arraycopy(data, 0, bookList, count, data.length);
      count = count+data.length;
   }
   //�߰����
   public void addBook(Book data){
	   bookList[count] = data;
	   count++;
   }
   //��Ϻ�����
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
   //����߰� (�˻����)
   public void searchBookList(String title){
	   int c = 0;
	   for(int i = 0;i<count ; i++){
         if(bookList[i].getTitle().equals(title)){
        	bookList[i].display(); 
        	c++;
         }
	   }
	   if(c==0){
		   System.out.println("��û�ѵ����������ϴ�.");
	   }
   }
   //��������߰�
   public void delete(String title){ //������ ������ ã�ƾ��Ѵ�.
	   for(int i = 0; i<count;i++){
		   if(bookList[i].getTitle().equals(title)){
			   bookList[i].getTitle().equals(title);
			   System.out.println("�����մϴ�.:");
			   bookList[i].display();
		       System.arraycopy(bookList, i+1, bookList, i, count-i);
		       count--;
		   break;
		   }
	   
	   }
	   
   }
}
