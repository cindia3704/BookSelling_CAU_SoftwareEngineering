import java.io.IOException;

public class LogOutControl implements LogOutInterface{
	DisplayInterface display= new Display();
	public void logOut(UserListFile userListFile, BookListFile bookListFile,SaleListFile saleListFile) throws IOException {
		userListFile.writeUserListToFile("userfile.txt");
		bookListFile.writeBookListToFile("bookfile.txt");
		saleListFile.writeSaleListToFile("salefile.txt");
		display.displayLogOut();
		//System.out.println("Logged Out Successfully!");
	}
}
 