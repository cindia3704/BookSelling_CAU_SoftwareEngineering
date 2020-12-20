import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookListTest {
	BookList bookList= new BookList();
	AddElement addElement=new AddController();
	DeleteElement deleteElement= new DeleteController();
	Book book1; 
	@BeforeEach
	void setUp() throws Exception {
		book1= new Book(1,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		addElement.addBook(bookList,book1);
	} 

	@Test
	void testNumBooks() {
		assertEquals(1,bookList.numBooks());
		Book book2= new Book(2,"kevin15","SW Engineering principles","1020152435313","Turing","null","20201103","1230","3");
		addElement.addBook(bookList,book2);
		assertEquals(2,bookList.numBooks());
		deleteElement.deleteBook(bookList,1);
		assertEquals(1,bookList.numBooks());
		Book book3= new Book(2,"kevin15","SW","1020152435336","null","null","20201106","null","null");
		addElement.addBook(bookList,book3);
		assertEquals(2,bookList.numBooks());
		deleteElement.deleteBook(bookList,"kevin15");
		assertEquals(0,bookList.numBooks());
	}
	@Test
	void testGetBook() {
		Book bookGot1=bookList.getBook(0);
		assertSame(book1,bookGot1);
		Book bookGot2=bookList.getBook("1020152435");
		assertSame(book1,bookGot2);
	}

	void testIncrementDecrementNumBooks() {
		bookList.incrementNumOfBooks();
		assertEquals(2,bookList.numBooks());
		bookList.incrementNumOfBooks();
		assertEquals(3,bookList.numBooks());
		bookList.decrementNumOfBooks();
		assertEquals(2,bookList.numBooks());
	}
}
