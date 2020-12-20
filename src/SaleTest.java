import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaleTest {
	private Sale sale;
	GeneralUser usr1;
	GeneralUser usr2;
	GeneralUser usr3;
	Book book;
	@BeforeEach
	void setUp() throws Exception {
		usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		usr2= new GeneralUser("kevin12","hello11","Kevin Lim","01091141221","kevin12@gmail.com",0);
		usr3=new GeneralUser("suzy11","1231suzy","Suzy Lee","01011112222","suzy1231@naver.com",1);
		book=new Book(1,"cindia1231","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		sale = new Sale(usr1,usr2,book);
	}
	@Test
	void testEquals() {
		GeneralUser usr4=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		GeneralUser usr5= new GeneralUser("kevin12","hello11","Kevin Lim","01091141221","kevin12@gmail.com",0);
		Book book2=new Book(1,"cindia1231","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		Sale sale2= new Sale(usr4,usr5,book2);
		assertTrue(sale2.equals(sale));
	}
	@Test
	void testGetter() {
		assertTrue(usr1.equals(sale.getSeller()));
		assertTrue(usr2.equals(sale.getbuyer()));
		assertTrue(book.equals(sale.getBookBuying()));
	}
	@Test
	void testSetter() {
		sale.setSeller(usr3);	
		sale.setBuyer(usr1);
		Book book2= new Book(2,"suzy11","Little Prince","112233445566","null","null","null","null","null");
		sale.setBook(book2);
		assertTrue(usr3.equals(sale.getSeller()));
		assertTrue(usr1.equals(sale.getbuyer()));
		assertTrue(book2.equals(sale.getBookBuying()));
	}
}
