import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerificationControllerTest {
	VerificationInterface verification= new VerificationController();
	AddElement addElement=new AddController();
	BookList bookList = new BookList();
	Book book1; 
	UserList userList = new UserList();
	GeneralUser usr1;
	@BeforeEach
	void setUp() throws Exception {
		book1= new Book(1,"cindia3704","Little Mermaid","1020152435","null","mermaid corp","20201205","123000","1");
		usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		addElement.addBook(bookList, book1);
		addElement.addUser(userList, usr1);
	}

	@Test
	void testIsBookPublishedDate() {
		String correctDate="20201103";
		assertTrue(verification.isBookPublishedDate(correctDate));
		String wrongDate[]= {"9991103","19991302","20150132"};
		for(int i=0;i<wrongDate.length;i++) {
			assertFalse(verification.isBookPublishedDate(wrongDate[i]));
		}
	}
	@Test
	void testIsPrice() {
		String correctPrice="1039281";
		String wrongPrice[]= {"1lskdjf1","asdf1"};
		assertTrue(verification.isPrice(correctPrice));
		for(int i=0;i<wrongPrice.length;i++) {
			assertFalse(verification.isPrice(wrongPrice[i]));
		}
	} 
	@Test
	void testisEmailAddress() {
		String correctEmail1="jisoo_1231@gmail.com";
		String correctEmail2="1010cindia@naver.com";
		String wrongEmail1="10194js@gmail";
		String wrongEmail2="cindiagmail.com";
		assertTrue(verification.isEmailAddress(correctEmail1));
		assertTrue(verification.isEmailAddress(correctEmail2));
		assertFalse(verification.isEmailAddress(wrongEmail1));
		assertFalse(verification.isEmailAddress(wrongEmail2));
	}
	@Test
	void testVerifyUser() {
		String id1="cindia1231";
		String password1="1231cindia";
		assertTrue(verification.verifyUser(userList,id1,password1));
		String id2="cindia3704";
		String password2="1231cindia11";
		assertFalse(verification.verifyUser(userList,id2,password2));
		
	}
	@Test
	void testcheckDuplicateID() {
		String IDDup="cindia1231";
		assertFalse(verification.checkDuplicateID(userList,IDDup));
		String IDNotDup="cindia";
		assertTrue(verification.checkDuplicateID(userList,IDNotDup));
		
	}
	@Test
	void testIsPhoneNumber() {
		boolean result=false;
		String correctPhoneNum="01099991111";
		if(verification.isPhoneNumber(correctPhoneNum)) {
			result=true;
		}
		assertTrue(result);
		
		String wrongPhoneNums[]= {"010111122222","0101111222","010-1111-2222","010a11a2222"};	//over 11 digits 
		for(int i=0;i<wrongPhoneNums.length;i++) {
			result=false;
			if(verification.isPhoneNumber(wrongPhoneNums[i])) {
				result=true;
			}
			else {
				result=false;
			}
			assertFalse(result);
		}
		
	}
	@Test
	void testisbnExists() {
		String isbn1="1020152435";
		assertTrue(verification.isbnExists(bookList, isbn1));
		String isbn2="1020152115";
		assertFalse(verification.isbnExists(bookList, isbn2));
		
	}
}
