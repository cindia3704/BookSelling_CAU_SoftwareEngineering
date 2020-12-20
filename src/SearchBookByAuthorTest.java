import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchBookByAuthorTest {
	AddElement addElement= new AddController();
	SearchBook search= new SearchBookByAuthor();
	BookList bookList=new BookList();
	Book b1;
	Book b2;
	Book b3;
	@BeforeEach
	void setUp() throws Exception {
		 b1= new Book(1,"cindia3704","Little Mermaid","1020152435","Princess Alica","mermaid corp","20201201","123","1");
		 b2= new Book(1,"cindia","Little Prince","1020152422","Prince Ali","mermaid corp","20001205","12000","2");
		 b3= new Book(1,"cindia","Aladin","1020152431","Prince Ali","mermaid corp","20201203","23000","1");
		 addElement.addBook(bookList, b1);
		 addElement.addBook(bookList, b2);
		 addElement.addBook(bookList, b3);
	}

	@Test
	void testSearchBookByAuthor() {
		Book[] bookList2= {b2,b3};
		Book[] searchedBooks=search.searchBooks(bookList, "Prince Ali");
		assertSame(bookList2[0],searchedBooks[0]);
		assertSame(bookList2[1],searchedBooks[1]);	
	}
}
