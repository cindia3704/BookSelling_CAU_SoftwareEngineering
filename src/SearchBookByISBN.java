
public class SearchBookByISBN implements SearchBook{
	public Book[] searchBooks(BookList bookList,String bookISBN) {
		Book[] booklistOfSameISBN = new Book[100];
		bookList.setNumSearchedBooks(0);
		int count=0;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookISBN().equals(bookISBN)) {
				
				booklistOfSameISBN[count++]=bookList.getBook(i);
				bookList.incrementNumSearchedBooks(1);
			}
		}
		return booklistOfSameISBN;
	}
}
