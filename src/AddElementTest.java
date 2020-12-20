import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddElementTest {
	AddElement addElement = new AddController();
	UserList userList =new UserList();
	GeneralUser usr1;
	BookList bookList= new BookList();
	Book book1;
	SaleList saleList = new SaleList();
	Sale sale1;
	@BeforeEach
	void setUp() throws Exception { 
		usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		book1= new Book(1,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		GeneralUser usr2=new GeneralUser("cindy12301","cindy1230","Cindy Kim","01088881111","cindia@naver.com",0);
		Sale sale = new Sale(usr1,usr2,book1);
	}
 
	@Test
	void testAddBook() {
		addElement.addBook(bookList, book1);
		assertEquals(1,bookList.numBooks());
		Book book2= new Book(2,"kevin15","SW Engineering principles","1020152435313","Turing","null","20201103","1230","3");
		addElement.addBook(bookList,book2);
		assertEquals(2,bookList.numBooks());
	}
	@Test
	void testAddUser() {
		addElement.addUser(userList, usr1);
		assertEquals(1,userList.numUsers());
		GeneralUser usr2=new GeneralUser("cindy12301","cindy1230","Cindy Kim","01088881111","cindia@naver.com",0);
		addElement.addUser(userList,usr2);
		assertEquals(2,userList.numUsers());
	}
	@Test
	void addSale() {
		addElement.addSale(saleList, sale1);
		assertEquals(1,saleList.numSales());
	}
}
