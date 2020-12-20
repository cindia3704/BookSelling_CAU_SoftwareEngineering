import java.util.regex.Pattern;
import java.io.IOException;
import java.util.Scanner;
public class UserList {
	private int maxOfUserList=100;
	private int numOfUsers=0;
	
	public GeneralUser[] userInformation = new GeneralUser[maxOfUserList];
	
	
	public int numUsers() {
		return this.numOfUsers;
	}
	
	public void incrementNumOfUsers() {
		numOfUsers++;
	}
	
	public void decrementNumOfUsers() {
		numOfUsers--;
	}
	 
	public GeneralUser getUser(int i) {
		if(isInRange(i)) {
			return userInformation[i];
		}
		else {
			return null;
		}
	}
	public GeneralUser getUser(String id) {
		boolean found=false;
		GeneralUser userFound=null;
		for(int i=0;i<numOfUsers;i++) {
			if(userInformation[i].getID().equals(id)) {
				found=true;
				userFound= userInformation[i];
			}
		}
		if(found==false) {
			userFound=null;
		}
		return userFound;
		
	}
	
	public boolean isInRange(int index) {
		if(index>=0 && index<100 && index<numOfUsers) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void showUserList() {
		System.out.println("\n===========================================================================================================");
		System.out.println("                                                 USER LIST                                                        ");
		System.out.println("===========================================================================================================");
		for(int i=0;i<numOfUsers;i++) {
			userInformation[i].printUser(i);
		}
	}
	
	
	public void changeUserState(String id) {
		for(int i=0;i<numOfUsers;i++) {
			if(userInformation[i].getID().equals(id)) {
				int uState=userInformation[i].getActiveState();
				if(uState==0) {
					userInformation[i].setActiveState(1);
				}
				else {
					userInformation[i].setActiveState(0);
				}
			}
		}
	}
	
	
	public GeneralUser logIn() {
		VerificationInterface verification=new VerificationController();
		Scanner input = new Scanner(System.in);
		System.out.println("=========================Log In=========================");
		boolean success=false;
		boolean admin=false; 
		String id=null;
		while(!success) {
			System.out.println("Enter ID: ");
			id=input.next();
			System.out.println("Enter Password: ");
			String password=input.next();
			success=verification.verifyUser(this,id, password);
			if(id.equals("admin")&&password.equals("nayana")) {
				admin=true;
				success=true;
			}
		}
		if(success) {
			//System.out.println("Log in Successful");
			if(!admin) {
				GeneralUser loggedUser=this.getUser(id);
				return loggedUser;
				//return 1;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	public void signUp(UserListFile userListFile) throws IOException {
		VerificationInterface verification=new VerificationController();
		Scanner input=new Scanner(System.in);
		System.out.println("========================Sign Up=========================");
		boolean success=false;
		String id=null;
		while(success==false) {
			System.out.println("Enter ID: ");
			id=input.nextLine();
			success=verification.checkDuplicateID(this,id);
		}
		System.out.println("Enter Password");
		String password=input.nextLine();
		System.out.println("Enter name");
		String name=input.nextLine();
		String phoneNumber="";
		do {
			System.out.println("Enter phone number");
			phoneNumber=input.nextLine();
		}while(!verification.isPhoneNumber(phoneNumber));
		String emailAddr="";
		do {
			System.out.println("Enter email address");
			emailAddr=input.nextLine();
		}while(!verification.isEmailAddress(emailAddr));
		GeneralUser user=new GeneralUser(id,password, name,phoneNumber,emailAddr,1);
		AddElement addElement=new AddController();
		addElement.addUser(this, user);
		userListFile.writeUserListToFile("userfile.txt");
	}
	
}
