import java.io.IOException;
import java.util.Scanner;

public class AdminController implements AdminInterface{
	DisplayInterface display=new Display();
	
	public void startMainMenuForAdmin(UserList userList,UserListFile userListFile,BookListFile bookListFile, BookList bookList,SaleListFile saleListFile) throws IOException {
		display.displayMainMenuForAdmin();
		Scanner input2=new Scanner(System.in);
		int mainMenuOption=input2.nextInt();
		switch(mainMenuOption) {
		case 1:  
			//SEARCH BOOK!
			adminSearchBook(bookList);
			this.startMainMenuForAdmin(userList,userListFile,bookListFile,bookList,saleListFile);
			break;
		case 2:
			//SEE USER LIST
			adminShowUserList(userList);
			this.startMainMenuForAdmin(userList,userListFile,bookListFile,bookList,saleListFile);
			break;
		case 3:
			//CHANGE USER STATE
			adminChangeUserState(userList);
			this.startMainMenuForAdmin(userList,userListFile,bookListFile,bookList,saleListFile);
			break;
		case 4:
			//DELETE USER
			adminDeleteUser(bookList,userList);
			this.startMainMenuForAdmin(userList,userListFile,bookListFile,bookList,saleListFile);
			break;
		case 5:
			//DELETE BOOK
			adminDeleteBook(bookList);
			this.startMainMenuForAdmin(userList,userListFile,bookListFile,bookList,saleListFile);
			break;
		case 6:
			LogOutInterface logOutControl=new LogOutControl();
			logOutControl.logOut(userListFile,bookListFile,saleListFile);
			break;
		
		}
	}
	
	public void adminSearchBook(BookList bookList) {
		Scanner adminOpForSearch = new Scanner(System.in);
		display.displayForBookSearch();
		int searchOp=adminOpForSearch.nextInt();
		SearchBookGeneral searchBookGeneral=new SearchBookGeneral();
		searchBookGeneral.searchBook(searchOp,bookList);
	}
	
	public void adminShowUserList(UserList userList) {
		userList.showUserList();
	}
	
	public void adminChangeUserState(UserList userList) {
		Scanner changeState=new Scanner(System.in);
		boolean invalidIndex=false;
		int indexChangeState=0;
		userList.showUserList();
		do{
			System.out.println("\nEnter user index to change user state");
			
			indexChangeState=changeState.nextInt();
			if(indexChangeState>userList.numUsers()||indexChangeState==0) {
				System.out.println("index is not valid! REENTER!!");
				invalidIndex=false;
			}
			else {
				invalidIndex=true;
			}
		}while(!invalidIndex);
		int userState=userList.userInformation[indexChangeState-1].getActiveState();
		
		if(userState==0) {
			userList.userInformation[indexChangeState-1].setActiveState(1);
			System.out.println("\n"+userList.userInformation[indexChangeState-1].getID()+"'s State has changed to "+userList.userInformation[indexChangeState-1].printActiveState(userList.userInformation[indexChangeState-1].getActiveState()));
		}
		else {
			userList.userInformation[indexChangeState-1].setActiveState(0);
			System.out.println("\n"+userList.userInformation[indexChangeState-1].getID()+"'s State has changed to "+userList.userInformation[indexChangeState-1].printActiveState(userList.userInformation[indexChangeState-1].getActiveState()));
		}
		
	}
	
	public void adminDeleteUser(BookList bookList, UserList userList){
		Scanner deleteUserOp = new Scanner(System.in);
		userList.showUserList();
		boolean invalidIndex=true;
		int indexDeleteUser=0;
		if(userList.numUsers()==0) {
			System.out.println("No Users registered to System...");
		}
		else {
			do{
				System.out.println("\nEnter user index to delete user");
				indexDeleteUser=deleteUserOp.nextInt();
				if(indexDeleteUser>userList.numUsers()||indexDeleteUser==0) {
					System.out.println("index is not valid! REENTER!!");
					invalidIndex=false;
				}
				else {
					invalidIndex=true;
				}
			}while(!invalidIndex);
			int userState=userList.userInformation[indexDeleteUser-1].getActiveState();
			if(userState==0) {
				DeleteElement deleteElement=new DeleteController();
				deleteElement.deleteBook(bookList,userList.userInformation[indexDeleteUser-1].getID());
				deleteElement.deleteUser(userList,userList.userInformation[indexDeleteUser-1].getID());
			}
			else {
				System.out.println("User is NOT deactivated! CANNOT DELETE USER");
			}
			
		}
				
	}
	
	public void adminDeleteBook(BookList bookList) {
		Scanner userOpForSearch = new Scanner(System.in);
		boolean invalidIndex=true;
		int deleteOpIndex=0;
		display.displayForBookSearch();
		int searchOp=userOpForSearch.nextInt();
		SearchBookGeneral searchBookGeneral=new SearchBookGeneral();
		Book searchedBooksArr[]=searchBookGeneral.searchBook(searchOp,bookList);
		do {
		System.out.println("Enter book index to delete book");
		deleteOpIndex=userOpForSearch.nextInt();
		if(deleteOpIndex>bookList.numSearchedBooks()||deleteOpIndex==0) {
			System.out.println("index is not valid! REENTER!!");
			invalidIndex=false;
		}
		else {
			invalidIndex=true;
		}
	}while(!invalidIndex);
		DeleteElement deleteElement= new DeleteController();
		int num=searchedBooksArr[deleteOpIndex-1].getBookUniqueNum();
		deleteElement.deleteBook(bookList,num);
	}
}
