import java.util.Scanner;

public class SearchBookBySellerID implements SearchBook{
	public Book[] searchBooks(BookList bookList,String bookSeller) {
		Book[] booklistOfSameSeller= new Book[100];
		bookList.setNumSearchedBooks(0);
		int count=0;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookSellerID().equals(bookSeller)) {
				
				booklistOfSameSeller[count++]=bookList.getBook(i);
				bookList.incrementNumSearchedBooks(1);
			}
		}
		return booklistOfSameSeller;
	}
}
