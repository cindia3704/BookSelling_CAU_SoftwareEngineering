import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookListFileTest {
	AddElement addElement= new AddController();
	BookListFile bookListFile =new BookListFile();
	Book book1;
	@BeforeEach
	void setUp() throws Exception {
		book1= new Book(1,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		addElement.addBook(bookListFile.bookList,book1);
	}

	@Test
	void testReadFileToList() throws IOException {
		bookListFile.writeBookListToFile("book.txt");
		BookList bookList1=bookListFile.readBookFileToList("book.txt");
		assertSame(bookList1,bookListFile.bookList);
	} 
	@Test
	void testWriteBookListToFile() throws IOException {
		assertEquals(1, bookListFile.bookList.numBooks());
		bookListFile.writeBookListToFile("book.txt");
		File tempFile = new File("book.txt");
		Scanner inputFile=new Scanner(tempFile);
	    String input=inputFile.nextLine();
	    String s="1:cindia3704:Little Mermaid:1020152435:null:mermaid corp:20201205:123000:1";
	    assertEquals(s,input);
	}
	@Test
	void testmakeLineToWrite() {
		String line= bookListFile.makeLineToWrite(0);
		assertEquals(line,"1:cindia3704:Little Mermaid:1020152435:null:mermaid corp:20201205:123000:1\n");
	}
}
