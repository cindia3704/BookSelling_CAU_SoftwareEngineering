
public class SearchBookByPublisher implements SearchBook{
	public Book[] searchBooks(BookList bookList,String bookPublisher) {
		Book[] booklistOfSamePublisher= new Book[100];
		bookList.setNumSearchedBooks(0);
		int count=0;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookPublisher().equals(bookPublisher)) {
				
				booklistOfSamePublisher[count++]=bookList.getBook(i);
				bookList.incrementNumSearchedBooks(1);
			} 
		}
		return booklistOfSamePublisher;
	} 
}
