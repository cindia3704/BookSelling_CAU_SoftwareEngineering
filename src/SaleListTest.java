import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaleListTest {
	SaleList saleList=new SaleList();
	AddElement addElement = new AddController();
	@BeforeEach
	void setUp() throws Exception {
		GeneralUser usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		GeneralUser usr2= new GeneralUser("kevin12","hello11","Kevin Lim","01091141221","kevin12@gmail.com",0);
		Book book=new Book(1,"cindia1231","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		Sale sale = new Sale(usr1,usr2,book);
		addElement.addSale(saleList,sale);
	}
	@Test
	void testNumSale() {
		assertEquals(1,saleList.numSales());
		GeneralUser usr3=new GeneralUser("cindia12","1231cindia","Cindia Jung","01011111111","cindia12@naver.com",1);
		GeneralUser usr4= new GeneralUser("kevin1","hello11","Kevin Lee","01091141221","kevin12@gmail.com",0);
		Book book2=new Book(1,"cindia1231","Little Prince","1020222435","null","little corp","20201105","12330","1");
		Sale sale2=new Sale(usr3,usr4,book2);
		addElement.addSale(saleList,sale2);
		assertEquals(2,saleList.numSales());
	}
	@Test
	void testgetSale() {
		Sale newsale = saleList.getSale(0);
		assertTrue(newsale.equals(saleList.saleInformation[0]));
	}
}
