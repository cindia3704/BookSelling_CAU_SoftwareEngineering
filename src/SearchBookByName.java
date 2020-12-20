

public class SearchBookByName implements SearchBook{
	public Book[] searchBooks(BookList bookList,String bookName) {
		Book[] booklistOfSameName = new Book[100];
		bookList.setNumSearchedBooks(0);
		int count=0;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookName().equals(bookName)) {
				
				booklistOfSameName[count++]=bookList.getBook(i);
				bookList.incrementNumSearchedBooks(1);
			}
		}
		return booklistOfSameName;
	}
}
