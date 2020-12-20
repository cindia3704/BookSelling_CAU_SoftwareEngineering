import java.util.regex.Pattern;

public class Book {
	private int bookUniqueNum;
	private String bookSellerID;
	private String bookName;
	private String bookISBN;
	private String bookAuthor;
	private String bookPublisher;
	private String bookPublishedDate;
	private String bookPrice;
	private String bookState;	//1.Excellent 2.Good 3.Fair
	//private String bookSellerEmail;
	public boolean equals(Book other){
		boolean result;
	    if((other == null) || (getClass() != other.getClass())){
	        result = false;
	    } // end if
	    else{
	        Book otherbook = (Book)other;
	        result = (bookUniqueNum==(other.getBookUniqueNum()) && bookSellerID.equals(other.getBookSellerID()) && bookName.equals(other.getBookName()) &&  bookISBN.equals(other.getBookISBN()) && bookAuthor.equals(other.getBookAuthor()) && bookPublisher.equals(other.getBookPublisher()) && bookPublishedDate.equals(other.getBookPublishedDate()) && bookPrice.equals(other.getBookPrice()) && bookState.equals(other.getBookState()));
	    } // end else

	    return result;
	}
	Book(Book book){
		this.setBookUniqueNum(book.getBookUniqueNum());
		this.setBookSellerID(book.getBookSellerID());
		this.setBookName(book.bookName);
		this.setBookISBN(book.getBookISBN());
		this.setBookAuthor(book.getBookAuthor());
		this.setBookPublisher(book.getBookPublisher());
		this.setBookPublishedDate(book.getBookPublishedDate());
		this.setBookPrice(book.getBookPrice());
		this.setBookState(book.getBookState());
	}
	Book(int bookUniqueNum,String bookSellerID, String name, String ISBN ,String author,String publisher, String publishedDate, String bookPrice, String bookState){
		this.setBookUniqueNum(bookUniqueNum);
		this.setBookSellerID(bookSellerID);
		this.setBookName(name);
		this.setBookISBN(ISBN);
		this.setBookAuthor(author);
		this.setBookPublisher(publisher);
		this.setBookPublishedDate(publishedDate);
		this.setBookPrice(bookPrice);
		this.setBookState(bookState);
	}

	
	public int getBookUniqueNum() {
		return this.bookUniqueNum;
	}
	
	public void setBookUniqueNum(int bookUniqueNum) {
		this.bookUniqueNum=bookUniqueNum;
	}
	
	public String getBookName() {
		return this.bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName=bookName;
	}
	
	public String getBookISBN() {
		return this.bookISBN;
	}
	
	public void setBookISBN(String bookISBN) {
		this.bookISBN=bookISBN;
	}
	public String getBookAuthor() {
		return this.bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor=bookAuthor;
	}
	public String getBookPublisher() 
	{
		return this.bookPublisher;
	}
	
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher=bookPublisher;
	}
	public String getBookPublishedDate() {
		return this.bookPublishedDate;
	}
	
	public void setBookPublishedDate(String bookPublishedDate) {
		this.bookPublishedDate=bookPublishedDate;
	}
	
	public String getBookPrice() {
		/*if(this.bookPrice==null) {
			return "null";
		}*/
		return this.bookPrice;
	}
	
	public void setBookPrice(String bookPrice) {
		this.bookPrice=bookPrice;
	}
	public String getBookState() {
		return this.bookState;
	}
	
	public void setBookState(String bookState) {
		this.bookState=bookState;
	}
	public String getBookSellerID() {
		return this.bookSellerID;
	}
	
	public void setBookSellerID(String bookSellerID) {
		this.bookSellerID=bookSellerID;
	}
	
	public String printAuthor(String bookAuthor) {
		if(bookAuthor.equals("null")){
			return " ";
		}
		else {
			return this.getBookAuthor();
		}
	}
	
	public String printPublisher(String bookPublisher) {
		if(bookPublisher.equals("null")){
			return " ";
		}
		else {
			return this.getBookPublisher();
		}
	}
	
	public String printPublishedDate(String bookPublishedDate) {
		if(bookPublishedDate.equals("null")){
			return " ";
		}
		else {
			return this.getBookPublishedDate();
		}
	}
	
	public String printPrice(String bookPrice) {
		if(bookPrice.equals("null")){
			return " ";
		}
		else {
			return this.getBookPrice();
		}
	}
	
	
	public String printState(String stateNum) {
		if(stateNum.equals("1")) {
			return "EXECELLENT";
		}
		else if(stateNum.equals("2")) {
			return "GOOD";
		}
		else if(stateNum.equals("3")){
			return "FAIR";
		}
		else {
			return " ";
		}
	}

	
	/*public void printBook() {
		System.out.println("BookName:"+this.getBookName()+" | "+
							"ISBN:"+this.getBookISBN()+" | "+
							"Author:"+this.printAuthor(this.getBookAuthor())+" | "+
							"Publisher:"+this.printPublisher(this.getBookPublisher())+" | "+
							"PublishedDate:"+this.printPublishedDate(this.getBookPublishedDate()));
	}*/
	public void printBook() {
		System.out.println("BookName:"+this.getBookName()+" | "+
							"ISBN:"+this.getBookISBN()+" | "+
							"Author:"+this.printAuthor(this.getBookAuthor())+" | "+
							"Publisher:"+this.printPublisher(this.getBookPublisher())+" | "+
							"PublishedDate:"+this.printPublishedDate(this.getBookPublishedDate())+" | "+
							"Price:"+this.printPrice(this.getBookPrice())+" | "+
							"State:"+this.printState(this.getBookState()));
	}
}
