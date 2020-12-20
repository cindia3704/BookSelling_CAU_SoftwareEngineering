import java.io.IOException;
import java.util.Scanner;

public class GeneralUserController implements GeneralUserInterface{
	private GeneralUser loggedUser;
	public GeneralUserController(GeneralUser user) {
		this.loggedUser=user;
	}
	DisplayInterface display= new Display();
	public void startMainMenuForUser(UserList userList,UserListFile userListFile,BookListFile bookListFile, BookList bookList,SaleListFile saleListFile, SaleList saleList) throws IOException{
		display.displayMainMenuForUser(loggedUser.getName());
		Scanner input2=new Scanner(System.in);
		int mainMenuOption=input2.nextInt();
		switch(mainMenuOption) {
		case 1: 
			//SEARCH BOOK! 
			userSearchBook(bookList);
			this.startMainMenuForUser(userList,userListFile,bookListFile,bookList,saleListFile, saleList);
			break;
		case 2: 
			//PURCHASE BOOK!
			userPurchaseBook(bookList,userList,saleList);
			//displayForBookPurchase();
		
			this.startMainMenuForUser(userList,userListFile,bookListFile,bookList,saleListFile, saleList);
			//displayForBookPurchase();
			break;
		case 3:
			//REGISTER BOOK
			registerBook(bookList);
			this.startMainMenuForUser(userList,userListFile,bookListFile,bookList,saleListFile, saleList);
			break;
		case 4:
			//MODIFY/DELETE MY BOOK
			displayMyBooks(bookList);
			this.startMainMenuForUser(userList,userListFile,bookListFile,bookList,saleListFile, saleList);
			break;
		case 5:
			LogOutInterface logOutControl=new LogOutControl();
			logOutControl.logOut(userListFile, bookListFile,saleListFile);
			break;
		}
	}
	public void userSearchBook(BookList bookList) {
		Scanner userOpForSearch = new Scanner(System.in);
		display.displayForBookSearch();
		int searchOp=userOpForSearch.nextInt();
		SearchBookGeneral searchBookGeneral = new SearchBookGeneral();
		searchBookGeneral.searchBook(searchOp,bookList);
		
	}
	public void userPurchaseBook(BookList bookList, UserList userList,SaleList saleList) {
		Scanner userOpForPurchase = new Scanner(System.in);
		display.displayForBookPurchase();
		int optionNumPurchase=userOpForPurchase.nextInt();
		purchaseBook(optionNumPurchase,bookList,userList,saleList);
	}
	
	public void displayMyBooks(BookList bookList) {
		Scanner choose = new Scanner(System.in);
		Book[] myBooks=new Book[100];
		int numOfMyBooks=0;
		System.out.println("========================My Book List=========================");
		SearchBook searchBook= new SearchBookBySellerID();
		myBooks=searchBook.searchBooks(bookList,loggedUser.getID());
		numOfMyBooks=bookList.numSearchedBooks();
		if(numOfMyBooks==0) {
			System.out.println("NO BOOKS!\n");
		}
		else {
			for(int i=0;i<numOfMyBooks;i++) {
				System.out.print("Index: "+(i+1)+" | ");
				myBooks[i].printBook();
				System.out.println("");
			}
			display.displayMyBookOptions();
			int index=choose.nextInt();
			switch(index) {
			case 1:
				modifyMyBook(bookList,myBooks);
				break;
			case 2: 
				deleteMyBook(bookList,myBooks);
				break;
			case 3:
				break;
			default: 
				System.out.println("Wrong input! Going to My Book List Page");
				displayMyBooks(bookList);
				break;
			}
		}
	}
	public void registerBook(BookList bookList) {
		VerificationInterface verification=new VerificationController();
		AddElement addElement=new AddController();
		boolean inputBookName=false;													//to assure that bookName is inserted
		Scanner registerBookInput = new Scanner(System.in);
		System.out.println("========================Register Book=========================");
		System.out.println("Type 'null' for blank information!");
		String bookName="";
		while(!inputBookName) {
			System.out.println("Enter Book Name: ");
			bookName=registerBookInput.nextLine();
			if(!bookName.equals("null")) {
				inputBookName=true;
			}
		}
		System.out.println("Enter Book Author: ");
		String bookAuthor=registerBookInput.nextLine();
		System.out.println("Enter Book Publisher: ");
		String bookPublisher=registerBookInput.nextLine();
		String bookPublishedDate="";
		do {
			System.out.println("Enter Book PublishedDate(YYYYMMDD): ");
			bookPublishedDate=registerBookInput.nextLine();
			if(bookPublishedDate.equals("null")) {
				break;
			}
		}while(!verification.isBookPublishedDate(bookPublishedDate));
		String bookPrice="";
		do {
			System.out.println("Enter Book Price: ");
			bookPrice=registerBookInput.nextLine();
		}while(!verification.isPrice(bookPrice));
		String bookState="";
		do{
			System.out.println("Enter Number for Book State(1.Excellent 2.Good 3.Fair): ");
			bookState=registerBookInput.nextLine();
		}while(!bookState.equals("1")&&!bookState.equals("2")&&!bookState.equals("3")&&!bookState.equals("null"));
		String bookISBN=addElement.makeISBN(bookList);
		Book book= new Book(bookList.numBooks()+1,loggedUser.getID(),bookName,bookISBN,bookAuthor,bookPublisher,bookPublishedDate,bookPrice,bookState);
		addElement.addBook(bookList,book);
	}
	public void modifyMyBook(BookList bookList, Book[] myBooks) {
		VerificationInterface verification=new VerificationController();
		Scanner modifyNum = new Scanner(System.in);
		boolean invalidIndex=true;
		int index=0;
		do {
			System.out.println("Enter book index to modify book");
			index=modifyNum.nextInt();
			if(index>bookList.numSearchedBooks()||index==0) {
				System.out.println("index is not valid! REENTER!!");
				invalidIndex=false;
			}
			else {
				invalidIndex=true;
			}
		}while(!invalidIndex);
		System.out.println("Type 'null' for blank information!");
		modifyNum.nextLine();
		String bookName="";
		boolean inputBookName=false;													//to assure that bookName is inserted
		while(!inputBookName) {
			System.out.println("Enter Book Name: ");
			bookName=modifyNum.nextLine();
			if(!bookName.equals("null")) {
				inputBookName=true;
			}
		}
		myBooks[index-1].setBookName(bookName);
		System.out.println("Enter Book Author: ");
		String bookAuthor=modifyNum.nextLine();
		myBooks[index-1].setBookAuthor(bookAuthor);
		System.out.println("Enter Book Publisher: ");
		String bookPublisher=modifyNum.nextLine();
		myBooks[index-1].setBookPublisher(bookPublisher);
		String bookPublishedDate="";
		do {
			System.out.println("Enter Book PublishedDate(YYYYMMDD): ");
			bookPublishedDate=modifyNum.nextLine();
		}while(!verification.isBookPublishedDate(bookPublishedDate));
		
		myBooks[index-1].setBookPublishedDate(bookPublishedDate);
		String bookPrice="";
		do{
			System.out.println("Enter Book Price: ");
			bookPrice=modifyNum.nextLine();
		}while(!verification.isPrice(bookPrice));
		myBooks[index-1].setBookPrice(bookPrice);
		String bookState="";
		do {
			System.out.println("Enter Number for Book State(1.Excellent 2.Good 3.Fair): ");
			 bookState=modifyNum.nextLine();
		}while(!bookState.equals("1")&&!bookState.equals("2")&&!bookState.equals("3")&&!bookState.contentEquals("null"));
		myBooks[index-1].setBookState(bookState);
	}
	
	public void deleteMyBook(BookList bookList, Book[] myBooks) {
		DeleteElement deleteElement= new DeleteController();
		Scanner deleteNum = new Scanner(System.in);
		boolean invalidIndex=true;
		int index=0;
		do{
			System.out.println("Enter book index to delete book");
			
			index=deleteNum.nextInt();
			if(index>bookList.numSearchedBooks()||index==0) {
				System.out.println("index is not valid! REENTER!!");
				invalidIndex=false;
			}
			else {
				invalidIndex=true;
			}
		}while(!invalidIndex);
		deleteElement.deleteBook(bookList,myBooks[index-1].getBookUniqueNum());
	}
	private void purchaseBook(int optionNumPurchase,BookList bookList,UserList userList,SaleList saleList) {
		SearchBookGeneral searchBookGeneral = new SearchBookGeneral();
		DeleteElement deleteElement= new DeleteController();
		AddElement addElement= new AddController();
		//searchBookGeneral.searchBook(searchOp,bookList);
		Book[] searchedBook=searchBookGeneral.searchBook(optionNumPurchase,bookList);
		boolean indexValid=true;
		int purchaseNum=0;
		if(bookList.numSearchedBooks()!=0) {
			do {
				System.out.println("Enter book index to purchase book");
				Scanner inputPurchaseNum= new Scanner(System.in);
				purchaseNum=inputPurchaseNum.nextInt();
				//SEND MESSAGE & DELETE BOOK! 
				if(purchaseNum>bookList.numSearchedBooks()||purchaseNum==0) {
					System.out.println("index is not valid! REENTER!!");
					indexValid=false;
				}
				else {
					indexValid=true;
				}
			}while(!indexValid);
			String sellerID=searchedBook[purchaseNum-1].getBookSellerID();
			
			if(sellerID.equals(loggedUser.getID())) {											//exception (trying to buy your own book)
				System.out.println("CANNOT BUY YOUR OWN BOOK!");
				purchaseBook(optionNumPurchase,bookList,userList,saleList);
			}
			else {
			GeneralUser seller=userList.getUser(sellerID);
			GeneralUser buyer=this.loggedUser;
			Book bookbuying=bookList.getBook(searchedBook[purchaseNum-1].getBookISBN());
			Sale newSale= new Sale(seller,buyer,bookbuying);
			System.out.println("Buying book :"+bookbuying.getBookName());
			newSale.sendPurchaseMessage(seller.getEmailAddr(), buyer.getEmailAddr(), bookbuying.getBookUniqueNum());
			addElement.addSale(saleList,newSale);
			deleteElement.deleteBook(bookList,bookbuying.getBookUniqueNum());
			
			}
		}
		
	}
	
}
