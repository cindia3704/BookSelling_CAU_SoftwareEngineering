import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaleListFile {
	private String fileName;
	public SaleList saleList=new SaleList();
	AddElement addElement=new AddController();
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
	private Sale makeSaleFromFile(String lineOfSale) {
		Sale saleInfoFromFile=null;
		String line=lineOfSale;
		
		String[] splitLineToAttribute = line.split(":");

		if(hasAllAttributes(splitLineToAttribute)) {
			//System.out.println("User not null");
			saleInfoFromFile = new Sale(new GeneralUser(splitLineToAttribute[0],splitLineToAttribute[1], splitLineToAttribute[2], splitLineToAttribute[3],splitLineToAttribute[4],Integer.parseInt(splitLineToAttribute[5])), new GeneralUser(splitLineToAttribute[6],splitLineToAttribute[7],splitLineToAttribute[8],splitLineToAttribute[9],splitLineToAttribute[10],Integer.parseInt(splitLineToAttribute[11])),new Book(Integer.parseInt(splitLineToAttribute[12]),splitLineToAttribute[13],splitLineToAttribute[14],splitLineToAttribute[15],splitLineToAttribute[16],splitLineToAttribute[17],splitLineToAttribute[18],splitLineToAttribute[19],splitLineToAttribute[20]));
			return saleInfoFromFile;
		}
		else {
			return null;
		}
		
	}
	private boolean hasAllAttributes(String[] splitLineToAttribute) {
		if(splitLineToAttribute.length==21) {
			//System.out.println("hass all attributes!");
			return true;
		}
		else {
			System.out.println("Doesn't have all Attributes!");
			return false;
		}	
	}
	public SaleList readSaleFileToList(String fileName) {
		Scanner inputFile=fileScan(fileName);
		if(inputFile!=null) {
			while(inputFile.hasNext()) {
				String lineOfSale=inputFile.nextLine();			//read a line from the file 
				//System.out.println("lineOfUser: "+lineOfUser);
				//A line of a userFile has format of : id:password:name:phonNumber:emailAddr:activeState
				Sale saleInfoFromFile= makeSaleFromFile(lineOfSale);
				if(saleInfoFromFile!=null) {
					try{
						addElement.addSale(saleList,saleInfoFromFile);
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Exceeded maximum books!");
					}
				}
			}
			inputFile.close();
			
			return saleList;
		}
		else {
			System.out.println("input File is Empty!");
			return saleList;
		}
		
	}
	public void writeSaleListToFile(String fileName) throws IOException {
		FileWriter fr=new FileWriter(fileName,false);	//clear first before writing to file
		for(int i=0;i<saleList.numSales();i++) {
			fr.write(makeLineToWrite(i));
		}
		fr.close();
		//System.out.println("Sale File Update Done!");
	}
	
	public String makeLineToWrite(int i) {
		//System.out.println("lets see: "+saleList.getSale(i).getSeller().getID();)
		String lineToWrite=saleList.getSale(i).getSeller().getID();
		lineToWrite+=":"+saleList.getSale(i).getSeller().getPassword();
		lineToWrite+=":"+saleList.getSale(i).getSeller().getName();
		lineToWrite+=":"+saleList.getSale(i).getSeller().getPhoneNumber();
		lineToWrite+=":"+saleList.getSale(i).getSeller().getEmailAddr();
		lineToWrite+=":"+saleList.getSale(i).getSeller().getActiveState();
		lineToWrite+=":"+saleList.getSale(i).getbuyer().getID();
		lineToWrite+=":"+saleList.getSale(i).getbuyer().getPassword();
		lineToWrite+=":"+saleList.getSale(i).getbuyer().getName();
		lineToWrite+=":"+saleList.getSale(i).getbuyer().getPhoneNumber();
		lineToWrite+=":"+saleList.getSale(i).getbuyer().getEmailAddr();
		lineToWrite+=":"+saleList.getSale(i).getbuyer().getActiveState();
		lineToWrite+=":"+String.valueOf(saleList.getSale(i).getBookBuying().getBookUniqueNum());
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookSellerID();
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookName();
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookISBN();
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookAuthor();
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookPublisher();
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookPublishedDate();
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookPrice();
				lineToWrite+=":"+saleList.getSale(i).getBookBuying().getBookState()+"\n";
		//System.out.println(lineToWrite);
				return lineToWrite;
	}
}
