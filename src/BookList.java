import java.math.BigInteger;
import java.util.Random;
import java.util.regex.Pattern;

public class BookList {
	private int maxOfBookList=200;
	private int numOfBooks=0;
	private int numOfSearchedBooks=0;
	public BookList() {
		
	}
	public BookList(BookList bookList) {
		this.maxOfBookList=bookList.maxOfBookList;
		this.numOfBooks=bookList.numOfBooks;
		this.numOfSearchedBooks=bookList.numOfBooks;
		this.bookInformation=bookList.bookInformation;
	}
	
	public Book[] bookInformation=new Book[maxOfBookList];
	
	public int numBooks() {
		return this.numOfBooks;
	}
	public void incrementNumOfBooks() {
		numOfBooks++;
	}
	public void decrementNumOfBooks() {
		numOfBooks--;
	}
	public int numSearchedBooks() {
		return this.numOfSearchedBooks;
	}
	
	public void incrementNumSearchedBooks(int i) {
		numOfSearchedBooks+=i;
	}
	
	public void setNumSearchedBooks(int i) {
		this.numOfSearchedBooks=i;
	}
	public Book getBook(int i) {
		if(isInRange(i)) {
			return bookInformation[i];
		}
		else {
			return null;
		}
	}
	
	public Book getBook(String ISBN) {
		boolean found=false;
		Book bookFound=null;
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookISBN().equals(ISBN)) {
				found=true;
				bookFound=bookInformation[i];
			}
		}
		if(found==false) {
			bookFound=null;
		}
		return bookFound;
	}
	
	public boolean isInRange(int index) {
		if(index>=0 && index<maxOfBookList && index<numOfBooks) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void showBookList() {
		System.out.println("\n===========================================================================================================");
		System.out.println("                                                 BOOK LIST                                                       ");
		System.out.println("===========================================================================================================");
		for(int i=0;i<numOfBooks;i++) {
			System.out.print("Index:"+(i+1)+" | ");
			bookInformation[i].printBook();
			System.out.println("");
		}
	}
	
	/*public void addBook(Book book) {
	//	Book b1=(Book) book;
		bookInformation[numOfBooks++]=book;
	}*/
	
	/*public void deleteBook(int bookUniqueNum) {
		boolean found=false;
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookUniqueNum()==bookUniqueNum) {
				found=true;
				for(int j=i+1;j<numOfBooks;j++) {
					bookInformation[i].setBookAuthor(bookInformation[j].getBookAuthor());
					bookInformation[i].setBookName(bookInformation[j].getBookName());
					bookInformation[i].setBookISBN(bookInformation[j].getBookISBN());
					bookInformation[i].setBookPublisher(bookInformation[j].getBookPublisher());
					bookInformation[i].setBookPublishedDate(bookInformation[j].getBookPublishedDate());
					bookInformation[i].setBookPrice(bookInformation[j].getBookPrice());
					bookInformation[i].setBookState(bookInformation[j].getBookState());
					bookInformation[i].setBookSellerID(bookInformation[j].getBookSellerID());
					bookInformation[i].setBookUniqueNum(bookInformation[j].getBookUniqueNum()-1);
					i++;
				}
				numOfBooks--;
			}
		}
		if(found==false) {
			System.out.println("Book is not Found!");
		}
	}
	public void deleteBook(String id) {
		boolean found=false;
		int loopTimes=numOfBooks;
		for(int i=0;i<loopTimes;i++) {
			//int index=0;
			for(int k=0;k<numOfBooks;k++) {
				int index=k;
				if(bookInformation[index].getBookSellerID().equals(id)) {
					found=true;
					for(int j=index+1;j<numOfBooks;j++) {
						bookInformation[index]=bookInformation[j];
						bookInformation[index].setBookUniqueNum(bookInformation[j].getBookUniqueNum()-1);
						index++;
					}
					numOfBooks--;
				}
			}
			
		}
		if(found==false) {
			System.out.println("Book is not Found!");
		}
	}*/
	
	/*public Book[] searchByName(String bookName) {
		Book[] booklist=new Book[100];
		numOfSearchedBooks=0;
		
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookName().equals(bookName)) {
				booklist[numOfSearchedBooks++]=getBook(i);
			}
		}
		return booklist;
	}*/
	/*public Book[] searchByPublisher(String bookPublisher) {
		Book[] booklist=new Book[100];
		numOfSearchedBooks=0;
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookPublisher().equals(bookPublisher)) {
				booklist[numOfSearchedBooks++]=getBook(i);
			}
		}
		return booklist;
	}*/
	/*public Book[] searchByPublishedDate(String bookPublishedDate) {
		Book[] booklist=new Book[100];
		numOfSearchedBooks=0;
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookPublishedDate().equals(bookPublishedDate)) {
				booklist[numOfSearchedBooks++]=getBook(i);
			}
		}
		return booklist;
	}*/
	/*public Book[] searchByISBN(String bookISBN) {
		Book[] booklist=new Book[100];
		numOfSearchedBooks=0;
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookISBN().equals(bookISBN)) {
				booklist[numOfSearchedBooks++]=getBook(i);
			}
		}
		return booklist;
	}*/
	
	/*public Book[] searchByAuthor(String bookAuthor) {
		Book[] booklist=new Book[100];
		numOfSearchedBooks=0;
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookAuthor().equals(bookAuthor)) {
				booklist[numOfSearchedBooks++]=getBook(i);
			}
		}
		return booklist;
	}*/
	
	/*public Book[] searchBySeller(String bookSeller) {
		Book[] booklist=new Book[100];
		numOfSearchedBooks=0;
		for(int i=0;i<numOfBooks;i++) {
			if(bookInformation[i].getBookSellerID().equals(bookSeller)) {
				booklist[numOfSearchedBooks++]=getBook(i);
			}
		}
		return booklist;
	}*/
	/*public boolean isbnExists(String isbn) {
		boolean result=false;
		for(int i=0;i<this.numBooks();i++) {
			if(this.bookInformation[i].getBookISBN().equals(isbn)) {
				result=true;
			}
		}
		return result;
	}*/
	
	/*public String makeISBN() {
		//HAVE TO COMPLETE
		VerificationInterface verification=new VerificationController();
		boolean exists=true;
		Random rand=new Random();
		int optionDigit=1;
		BigInteger maxLimit1=new BigInteger("9999999999");
		BigInteger minLimit1=new BigInteger("1000000000");
		BigInteger maxLimit2=new BigInteger("9999999999999");
		BigInteger minLimit2=new BigInteger("1000000000000");
		int opDigit=rand.nextInt(optionDigit);
		int isbnNum=0;
		int radix=10;
		String isbn="";
		if(opDigit==0) {
			//10자리 ISBN
			while(exists) {
				BigInteger option1=maxLimit1.subtract(minLimit1);
				int len=maxLimit1.bitLength();
				BigInteger res=new BigInteger(len,rand);
				if(res.compareTo(minLimit1)<0) {
					res=res.add(minLimit1);
				}
				if(res.compareTo(option1)>=0) {
					res=res.mod(option1).add(minLimit1);
				}
				isbn=res.toString(radix);
				if(!verification.isbnExists(this,isbn)) {
					exists=false;
				}
			}
		}
		else {
			//13자기 ISBN
			while(!exists) {
				BigInteger option2=maxLimit2.subtract(minLimit2);
				int len=maxLimit2.bitLength();
				BigInteger res=new BigInteger(len,rand);
				if(res.compareTo(minLimit2)<0) {
					res=res.add(minLimit2);
				}
				if(res.compareTo(option2)>=0) {
					res=res.mod(option2).add(minLimit2);
				}
				isbn=res.toString(radix);
				if(verification.isbnExists(this,isbn)) {
					exists=true;
				}
			}
		}
		return isbn;
	}*/
	/*public boolean isBookPublishedDate(String bookPublishedDate) {
		if((Pattern.matches("[0-9]*$",bookPublishedDate)&&bookPublishedDate.length()==8)) {
			int year =Integer.parseInt(bookPublishedDate.substring(0,4));
			int month=Integer.parseInt(bookPublishedDate.substring(4,6));
			int day=Integer.parseInt(bookPublishedDate.substring(6,8));
			
			if(year<1000) {
				System.out.println("Year is not in range. REENTER!!");
				return false;
			}
			else if(month<1||month>12) {
				System.out.println("Month is not in range. REENTER!!");
				return false;
			}
			else if(day<1||day>31) {
				System.out.println("Day is not in range. REENTER!!");
				return false;
			}else {
				return true;
			}
		}
		else {
			System.out.println("Book published date is not in format. REENTER!!");
			return false;
		}
	}
	public boolean isPrice(String bookPrice) {
		if(Pattern.matches("[0-9]*$",bookPrice)||bookPrice.equals("null")) {
			return true;
		}
		else {
			System.out.println("Price is not in format. REENTER!!");
			return false;
		}
	}*/
}
