import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaleListFileTest {
	AddElement addElement= new AddController();
	SaleListFile saleListFile = new SaleListFile();
	Sale sale;
	@BeforeEach
	void setUp() throws Exception {
		GeneralUser usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		GeneralUser usr2= new GeneralUser("kevin12","hello11","Kevin Lim","01091141221","kevin12@gmail.com",0);
		GeneralUser usr3=new GeneralUser("suzy11","1231suzy","Suzy Lee","01011112222","suzy1231@naver.com",1);
		Book book=new Book(1,"cindia1231","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		sale = new Sale(usr1,usr2,book);
		addElement.addSale(saleListFile.saleList,sale);
	}  

	@Test
	void testReadsaleFileToList() throws IOException {
		saleListFile.writeSaleListToFile("sale.txt");
		SaleList saleList1= saleListFile.readSaleFileToList("sale.txt");
		assertSame(saleList1,saleListFile.saleList);
	}
	@Test
	void testWriteSaleListToFile() throws IOException {
		assertEquals(1, saleListFile.saleList.numSales());
		saleListFile.writeSaleListToFile("sale.txt");
		File tempFile = new File("sale.txt");
		Scanner inputFile=new Scanner(tempFile);
	    String input=inputFile.nextLine();
	    String s="cindia1231:1231cindia:Cindia Kim:01099991111:cindia1231@naver.com:1:kevin12:hello11:Kevin Lim:01091141221:kevin12@gmail.com:0:1:cindia1231:Little Mermaid:1020152435:null:mermaid corp:20201205:123000:1";
	    assertEquals(s,input);
		
	}
	@Test
	void testMakeLineToWrite() {
		String line= saleListFile.makeLineToWrite(0);
		assertEquals(line,"cindia1231:1231cindia:Cindia Kim:01099991111:cindia1231@naver.com:1:kevin12:hello11:Kevin Lim:01091141221:kevin12@gmail.com:0:1:cindia1231:Little Mermaid:1020152435:null:mermaid corp:20201205:123000:1\n");
	}
}
