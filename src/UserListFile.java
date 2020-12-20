import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserListFile {
	private String fileName;
	public UserList userList=new UserList();
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
	
	private GeneralUser makeUserFromFile(String lineOfUser) {
		VerificationInterface verification=new VerificationController();
		GeneralUser userInfoFromFile=null;
		String line=lineOfUser;
		
		String[] splitLineToAttribute = line.split(":");
		if(hasAllAttributes(splitLineToAttribute)) {
			//System.out.println("User not null");
			if(verification.isPhoneNumber(splitLineToAttribute[3])&& verification.isEmailAddress(splitLineToAttribute[4])) {
				userInfoFromFile = new GeneralUser(splitLineToAttribute[0],splitLineToAttribute[1], splitLineToAttribute[2], splitLineToAttribute[3],splitLineToAttribute[4],Integer.parseInt(splitLineToAttribute[5]));
				return userInfoFromFile;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
		
	}
	private boolean hasAllAttributes(String[] splitLineToAttribute) {
		if(splitLineToAttribute.length==6) {
			//System.out.println("has all attributes!");
			return true;
		}
		else {
			return false;
		}
	}
	
	public UserList readUserFileToList(String fileName) {
		Scanner inputFile=fileScan(fileName);
		if(inputFile!=null) {
			while(inputFile.hasNext()) {
				String lineOfUser=inputFile.nextLine();			//read a line from the file 
				//System.out.println("lineOfUser: "+lineOfUser);
				//A line of a userFile has format of : id:password:name:phonNumber:emailAddr:activeState
				GeneralUser userInfoFromFile= makeUserFromFile(lineOfUser);
				if(userInfoFromFile!=null) {
					try{
						AddElement addElement=new AddController();
						addElement.addUser(userList,userInfoFromFile);
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Exceeded maximum users!");
					}
				}
			}
			inputFile.close();
			
			return userList;
		}
		else {
			System.out.println("input File is Empty!");
			return userList;
		}
		
	}
	public void writeUserListToFile(String fileName) throws IOException {
		FileWriter fr=new FileWriter(fileName,false);	//clear first before writing to file
		for(int i=0;i<userList.numUsers();i++) {
			fr.write(makeLineToWrite(i));
		}
		fr.close();
		//System.out.println("User File Update Done!");
	}
	
	public String makeLineToWrite(int i) {
		String lineToWrite=userList.getUser(i).getID();
				lineToWrite+=":"+userList.getUser(i).getPassword();
				lineToWrite+=":"+userList.getUser(i).getName();
				lineToWrite+=":"+userList.getUser(i).getPhoneNumber();
				lineToWrite+=":"+userList.getUser(i).getEmailAddr();
				lineToWrite+=":"+userList.getUser(i).getActiveState()+"\n";
		return lineToWrite;
	}
	
}
