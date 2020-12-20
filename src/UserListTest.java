import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserListTest {
	UserList userList=new UserList();
	AddElement addElement = new AddController();
	DeleteElement deleteElement=new DeleteController();
	GeneralUser usr1;
	@BeforeEach
	void setUp() {
		usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		addElement.addUser(userList,usr1);
	}
	
	@Test
	void testNumUsersAndAddUserAndDeleteUser() {
		assertEquals(1,userList.numUsers());
		GeneralUser usr2=new GeneralUser("cindy12301","cindy1230","Cindy Kim","01088881111","cindia@naver.com",0);
		addElement.addUser(userList,usr2);
		assertEquals(2,userList.numUsers());
		deleteElement.deleteUser(userList,"cindia1231");
		assertEquals(1,userList.numUsers());
		deleteElement.deleteUser(userList,"cindy12301");
		assertEquals(0,userList.numUsers());
	}
	@Test
	void testGetUser() {
		GeneralUser userGot1=userList.getUser(0);
		assertSame(usr1,userGot1);
		GeneralUser userGot2=userList.getUser("cindia1231");
		assertSame(usr1,userGot2);
		//GeneralUser usr2=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1)
	}
	@Test
	void testChangeUserState() {
		userList.changeUserState("cindia1231");
		assertSame(0,usr1.getActiveState());
		userList.changeUserState("cindia1231");
		assertSame(1,usr1.getActiveState()); 
	}
	@Test
	void testIncrementDecrementNumUser() {
		assertEquals(1,userList.numUsers());
		userList.incrementNumOfUsers();
		assertEquals(2,userList.numUsers());
		userList.decrementNumOfUsers();
		assertEquals(1,userList.numUsers());
	}
	
}
