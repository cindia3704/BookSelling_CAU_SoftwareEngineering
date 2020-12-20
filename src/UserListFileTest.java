import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import junit.framework.Assert;
 
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.util.Scanner;
class UserListFileTest {
	UserListFile userListFile=new UserListFile();
	GeneralUser usr1;
	AddElement addElement= new AddController();
	//UserList userList;
	@BeforeEach
	void setUp(){
		usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		addElement.addUser(userListFile.userList,usr1);
	}

	@Test
	void testWriteUserListToFile() throws IOException {
		//File tempFile = tempFolder.newFile("userFile.txt");
		assertEquals(1, userListFile.userList.numUsers());
		userListFile.writeUserListToFile("user.txt");
		File tempFile = new File("user.txt");
		Scanner inputFile=new Scanner(tempFile);
	    String input=inputFile.nextLine();
	    String s="cindia1231:1231cindia:Cindia Kim:01099991111:cindia1231@naver.com:1";
	    assertEquals(s,input);
	}
	@Test  
	void testMakeLineToWrite() {
		String line= userListFile.makeLineToWrite(0);
		assertEquals(line,"cindia1231:1231cindia:Cindia Kim:01099991111:cindia1231@naver.com:1\n");
	}
	@Test 
	void testReadUserFileToList() throws IOException {
		//userListFile.File tempFile = new File("userFile.txt");
		userListFile.writeUserListToFile("user.txt");
		UserList userList1= userListFile.readUserFileToList("user.txt");
		assertSame(userList1,userListFile.userList);
	}
}
