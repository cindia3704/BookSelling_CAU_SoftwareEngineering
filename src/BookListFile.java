import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BookListFile {
	private String fileName;
	public BookList bookList=new BookList();
	private Scanner fileScan(String fileName) {
		try {
			File file=new File(fileName);
			//System.out.println("Found file!!");
			return new Scanner(file);
		}catch(Exception e) {
			System.out.println("File is unfound!");
			return null;
		}
	}
	private Book makeBookFromFile(String lineOfBook) {
		Book bookInfoFromFile=null;
		String line=lineOfBook;
		
		String[] splitLineToAttribute = line.split(":");

		if(hasAllAttributes(splitLineToAttribute)) {
			//System.out.println("User not null");
			bookInfoFromFile = new Book(Integer.parseInt(splitLineToAttribute[0]),splitLineToAttribute[1], splitLineToAttribute[2], splitLineToAttribute[3],splitLineToAttribute[4],splitLineToAttribute[5],splitLineToAttribute[6],splitLineToAttribute[7],splitLineToAttribute[8]);
			return bookInfoFromFile;
		}
		else {
			return null;
		}
		
	}
	private boolean hasAllAttributes(String[] splitLineToAttribute) {
		if(splitLineToAttribute.length==9) {
			//System.out.println("hass all attributes!");
			return true;
		}
		else {
			System.out.println("Doesn't have all Attributes!");
			return false;
		}
	}
	
	public BookList readBookFileToList(String fileName) {
		Scanner inputFile=fileScan(fileName);
		//AddElement addElement=new BookList(bookList);
		if(inputFile!=null) {
			while(inputFile.hasNext()) {
				String lineOfBook=inputFile.nextLine();			//read a line from the file 
				//System.out.println("lineOfUser: "+lineOfUser);
				//A line of a userFile has format of : id:password:name:phonNumber:emailAddr:activeState
				Book bookInfoFromFile= makeBookFromFile(lineOfBook);
				if(bookInfoFromFile!=null) {
					try{
						AddElement addElement= new AddController();
						addElement.addBook(bookList,bookInfoFromFile);
						//addElement.add(bookInfoFromFile);
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Exceeded maximum books!");
					}
				}
			}
			inputFile.close();
			
			return bookList;
		}
		else {
			System.out.println("input File is Empty!");
			return bookList;
		}
		
	}
	
	public void writeBookListToFile(String fileName) throws IOException {
		FileWriter fr=new FileWriter(fileName,false);	//clear first before writing to file
		for(int i=0;i<bookList.numBooks();i++) {
			fr.write(makeLineToWrite(i));
		}
		fr.close();
		//System.out.println("Book File Update Done!");
	}
	
	public String makeLineToWrite(int i) {
		String lineToWrite=String.valueOf(bookList.getBook(i).getBookUniqueNum());
				lineToWrite+=":"+bookList.getBook(i).getBookSellerID();
				lineToWrite+=":"+bookList.getBook(i).getBookName();
				lineToWrite+=":"+bookList.getBook(i).getBookISBN();
				lineToWrite+=":"+bookList.getBook(i).getBookAuthor();
				lineToWrite+=":"+bookList.getBook(i).getBookPublisher();
				lineToWrite+=":"+bookList.getBook(i).getBookPublishedDate();
				lineToWrite+=":"+bookList.getBook(i).getBookPrice();
				lineToWrite+=":"+bookList.getBook(i).getBookState()+"\n";
		return lineToWrite;
	}
	
}
