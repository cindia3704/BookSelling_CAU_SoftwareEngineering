import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Control{
	public GeneralUser loggedUser=null;
	private Display display=new Display();
	public Admin loggedAdmin=null;
	//Display display=new Display(loggedUser.getName());
	public void start() throws IOException {
		//Read data from files!
		UserListFile userListFile = new UserListFile();
		UserList userList=userListFile.readUserFileToList("userfile.txt");
		BookListFile bookListFile = new BookListFile();
		BookList bookList=bookListFile.readBookFileToList("bookfile.txt");
		SaleListFile saleListFile=new SaleListFile();
		SaleList saleList=saleListFile.readSaleFileToList("salefile.txt");
		 
		Scanner sc=new Scanner(System.in);
		display.displayStartMenu();
		int startMenuOption=sc.nextInt();

		switch(startMenuOption) {
		case 1: //Login
			loggedUser=userList.logIn();
			if(loggedUser!=null) { // User logged in is General User
				GeneralUserInterface userInt=new GeneralUserController(loggedUser);
				userInt.startMainMenuForUser(userList,userListFile,bookListFile,bookList,saleListFile,saleList);
			}
			else { //User logged in is Admin
				AdminInterface adminInt=new AdminController();
				loggedAdmin=new Admin();
				adminInt.startMainMenuForAdmin(userList, userListFile,bookListFile,bookList,saleListFile);
			}
			break;
		case 2://SignUp
			userList.signUp(userListFile);
			this.start();
			break;
		}
		sc.close();
	}
	public static void main(String[] args) throws IOException{
		Control ctrl = new Control();
		ctrl.start();
	}

}
