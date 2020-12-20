
public class SearchBookByAuthor implements SearchBook{
	public Book[] searchBooks(BookList bookList,String bookAuthor) {
		Book[] booklistOfSameAuthor = new Book[100];
		bookList.setNumSearchedBooks(0);
		int count=0;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookAuthor().equals(bookAuthor))  {
				booklistOfSameAuthor[count++]=bookList.getBook(i);
				bookList.incrementNumSearchedBooks(1);
			}
		}
		return booklistOfSameAuthor;
	}
} 
