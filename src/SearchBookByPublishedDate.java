
public class SearchBookByPublishedDate implements SearchBook{
	public Book[] searchBooks(BookList bookList,String bookDate) {
		Book[] booklistOfSameDate= new Book[100];
		bookList.setNumSearchedBooks(0);
		int count=0;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookPublishedDate().equals(bookDate)) {
				
				booklistOfSameDate[count++]=bookList.getBook(i);
				bookList.incrementNumSearchedBooks(1);
			}
		}
		return booklistOfSameDate;
	}
}
