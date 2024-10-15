package chap06;

public class Book {
	//field
	 private String title;
	 private String bookNo;
	 private int price;
	 
	 //constructor
	 Book(String title, String bookNo, int price){
		 this.title = title;
		 this.bookNo = bookNo;
		 this.price = price;
	 }

	 //method
	 public String getTitle() {
		 return title;
	 }
	 
	 public void setTitle(String title) {
		 this.title = title;
	 }
	 
	 public String getBookNo() {
		 return bookNo;
	 }
	 
	 public void setBookNo(String bookNo) {
		 this.bookNo = bookNo;
	 }
	 
	 public int getPrice() {
		 return price;
	 }
	 
	 public void setPrice(int price) {
		 this.price = price;
	 }
	 
	 
}
