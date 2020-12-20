import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteElementTest {
	DeleteElement deleteElement= new DeleteController();
	AddElement addElement = new AddController();
	UserList userList =new UserList();
	GeneralUser usr1;
	BookList bookList= new BookList();
	Book book1;
	Book book2;

	@BeforeEach
	void setUp() throws Exception {
		usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		book1= new Book(1,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		book2= new Book(2,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		GeneralUser usr2=new GeneralUser("cindy12301","cindy1230","Cindy Kim","01088881111","cindia@naver.com",0);
		addElement.addBook(bookList, book1);
		addElement.addUser(userList, usr1);
		addElement.addUser(userList, usr2);
		addElement.addBook(bookList, book2);
	}

	@Test
	void testDeleteBook() {
		assertEquals(2,bookList.numBooks());
		deleteElement.deleteBook(bookList, 1);
		assertEquals(1,bookList.numBooks());	
	}
	
	@Test
	void testDeleteBookOfSeller() {
		assertEquals(2,bookList.numBooks());
		deleteElement.deleteBook(bookList, "cindia3704");
		assertEquals(0,bookList.numBooks());
	}
	@Test
	void testDeleteUser() {
		assertEquals(2,userList.numUsers());
		deleteElement.deleteUser(userList, "cindy12301");
		assertEquals(1,userList.numUsers());
	}
}
