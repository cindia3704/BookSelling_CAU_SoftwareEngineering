import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
	private Book b1;
	private Book b2; 
	//private Book b3; 

	@BeforeEach
	void setUp() throws Exception {
		b1= new Book(1,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		b2= new Book(2,"kevin15","SW Engineering principles","1020152435313","Turing","null","20201103","1230","3");
	}

	@Test
	void testEqualse() {
		Book b3= new Book(1,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		assertTrue(b1.equals(b3));
	}
	@Test
	void testBookUniqueNumGetter() {
		assertEquals(1,b1.getBookUniqueNum());
		assertEquals(2,b2.getBookUniqueNum());
	}
	@Test
	void testBookNameGetter() {
		assertEquals("Little Mermaid",b1.getBookName());
		assertEquals("SW Engineering principles",b2.getBookName());
	}
	@Test
	void testBookISBNGetter() {
		assertEquals("1020152435",b1.getBookISBN());
		assertEquals("1020152435313",b2.getBookISBN());
	}
	@Test
	void testBookAuthorGetter() {
		assertEquals("null",b1.getBookAuthor());
		assertEquals("Turing",b2.getBookAuthor());
	}
	@Test
	void testBookPublisherGetter() {
		assertEquals("mermaid corp",b1.getBookPublisher());
		assertEquals("null",b2.getBookPublisher());
	}
	@Test
	void testBookPublishedDateGetter() {
		assertEquals("20201205",b1.getBookPublishedDate());
		assertEquals("20201103",b2.getBookPublishedDate());
	}
	@Test
	void testBookPriceGetter() {
		assertEquals("123000",b1.getBookPrice());
		assertEquals("1230",b2.getBookPrice());
	}
	@Test
	void testBookStateGetter() {
		assertEquals("1",b1.getBookState());
		assertEquals("3",b2.getBookState());
	}
	@Test
	void testBookSellerIDGetter() {
		assertEquals("cindia3704",b1.getBookSellerID());
		assertEquals("kevin15",b2.getBookSellerID());
	}
	@Test
	void testBookUniqueNumSetter() {
		b1.setBookUniqueNum(3);
		assertEquals(3,b1.getBookUniqueNum());
	}
	@Test
	void testBookNameSetter() {
		b1.setBookName("Apple");
		assertEquals("Apple",b1.getBookName());
	}
	@Test
	void testBookISBNSetter() {
		b1.setBookISBN("1020103027");
		assertEquals("1020103027",b1.getBookISBN());
	}
	@Test
	void testBookAuthorSetter() {
		b1.setBookAuthor("Steve Jobs");
		assertEquals("Steve Jobs",b1.getBookAuthor());
	}
	@Test
	void testBookPublisherSetter() {
		b1.setBookPublisher("apple corp");
		assertEquals("apple corp",b1.getBookPublisher());
	}
	@Test
	void testBookPublishedDateSetter() {
		b1.setBookPublishedDate("20170402");
		assertEquals("20170402",b1.getBookPublishedDate());
	}
	@Test
	void testBookPriceSetter() {
		b1.setBookPrice("null");
		assertEquals("null",b1.getBookPrice());
	}
	@Test
	void testBookStateSetter() {
		b1.setBookState("2");
		assertEquals("2",b1.getBookState());
	}
	@Test
	void testBookSellerIDSetter() {
		b1.setBookSellerID("cindia1231");
		assertEquals("cindia1231",b1.getBookSellerID());
	}
}
