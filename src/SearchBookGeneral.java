import java.util.Scanner;

public class SearchBookGeneral {
	Book[] searchedBook= new Book[100];
	public Book[] searchBook(int optionNumForSearch,BookList bookList) {
		SearchBook searchBook=null;
		//Book[] searchedBook= new Book[100];
		Scanner inputString= new Scanner(System.in);
		switch(optionNumForSearch) {
		case 1:
			System.out.println("Book Name: ");
			String bookName=inputString.nextLine();
			searchBook= new SearchBookByName();
			searchedBook=searchBook.searchBooks(bookList,bookName);
			//searchedBook=searchBookByName(bookList);
			break;
		case 2:
			System.out.println("Book ISBN: ");
			String bookISBN=inputString.nextLine();
			searchBook= new SearchBookByISBN();
			searchedBook=searchBook.searchBooks(bookList,bookISBN);
			//searchedBook=searchBookByISBN(bookList);
			break;
		case 3:
			System.out.println("Book Author: ");
			String bookAuthor=inputString.nextLine();
			searchBook= new SearchBookByAuthor();
			searchedBook=searchBook.searchBooks(bookList,bookAuthor);
			//searchedBook=searchBookByAuthor(bookList);
			break;
		case 4:
			System.out.println("Book Seller ID: ");
			String bookSeller=inputString.nextLine();
			searchBook= new SearchBookBySellerID();
			searchedBook=searchBook.searchBooks(bookList,bookSeller);
		//	searchedBook=searchBookBySellerID(bookList);
			break;
		case 5: 
			System.out.println("Book Publisher: ");
			String bookPublisher=inputString.nextLine();
			searchBook= new SearchBookByPublisher();
			searchedBook=searchBook.searchBooks(bookList,bookPublisher);
			//searchedBook=searchBookByPublisher(bookList);
			break;
		case 6:
			System.out.println("Book Published Date: ");
			String bookPublishedDate=inputString.nextLine();
			searchBook= new SearchBookByPublishedDate();
			searchedBook=searchBook.searchBooks(bookList,bookPublishedDate);
			//searchedBook=searchBookByPublishedDate(bookList);
			break;
		case 7:
			break;
		default:
			System.out.println("Invalid Input! Moving to search book again");
			searchBook(optionNumForSearch,bookList);
		}
		int numOfSearchedBooks=bookList.numSearchedBooks();
		if(optionNumForSearch==7) {
			return searchedBook;
		}
		if(numOfSearchedBooks== 0&& optionNumForSearch!=7) {											//exception(NO BOOKS FOUND)
			System.out.println("NO BOOKS FOUND");
		}	
		else{
			System.out.println("\n========================Searched Book List=========================");
			for(int i=0;i<numOfSearchedBooks;i++) {
				System.out.print("Index:"+(i+1)+" | ");
				searchedBook[i].printBook();
			}
			System.out.println("");
		}
		return searchedBook;
	}
}
