import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeneralUserTest {
	private GeneralUser usr1;
	private GeneralUser usr2;
	private GeneralUser usr3;
	@BeforeEach
	void setUp() {
		usr1=new GeneralUser("cindia1231","1231cindia","Cindia Kim","01099991111","cindia1231@naver.com",1);
		usr2= new GeneralUser("kevin12","hello11","Kevin Lim","01091141221","kevin12@gmail.com",0);
		usr3 = new GeneralUser(usr1);
	}
	@Test 
	void testEquals() {
		GeneralUser usr4= new GeneralUser("kevin12","hello11","Kevin Lim","01091141221","kevin12@gmail.com",0);
		assertTrue(usr2.equals(usr4));
	}
	@Test
	void testIDGetter() {
		assertEquals("cindia1231",usr1.getID());
		assertEquals("kevin12",usr2.getID());
		assertEquals(usr1.getID(),usr3.getID());
		
	}
	@Test
	void testPasswordGetter() {
		assertEquals("1231cindia",usr1.getPassword());
		assertEquals("hello11",usr2.getPassword());
		assertEquals(usr1.getPassword(),usr3.getPassword());
	}
	@Test
	void testNameGetter() {
		assertEquals("Cindia Kim",usr1.getName());
		assertEquals("Kevin Lim",usr2.getName());
		assertEquals(usr1.getName(),usr3.getName());
	}
	@Test
	void testPhoneNumberGetter() {
		assertEquals("01099991111",usr1.getPhoneNumber());
		assertEquals("01091141221",usr2.getPhoneNumber());
		assertEquals(usr1.getPhoneNumber(),usr3.getPhoneNumber());
	}
	@Test
	void testEmailGetter() {
		assertEquals("cindia1231@naver.com",usr1.getEmailAddr());
		assertEquals("kevin12@gmail.com",usr2.getEmailAddr());
		assertEquals(usr1.getEmailAddr(),usr3.getEmailAddr());
	}
	@Test
	void testActiveStateGetter() {
		assertEquals(1,usr1.getActiveState());
		assertEquals(0,usr2.getActiveState());
		assertEquals(usr1.getActiveState(),usr3.getActiveState());
	}
	
	@Test
	void testIDSetter() {
		boolean result=true;
		usr1.setID("jisoo123");
		assertEquals("jisoo123",usr1.getID());
		if(usr1.getID().equals(usr3.getID())) {
			result=true;
		}
		else {
			result=false;
		}
		assertFalse(result);
	}
	@Test
	void testPasswordSetter() {
		boolean result=true;
		usr1.setPassword("123123");
		assertEquals("123123",usr1.getPassword());
		if(usr1.getPassword().equals(usr3.getPassword())) {
			result=true;
		}
		else {
			result=false;
		}
		assertFalse(result);
	}
	@Test
	void testNameSetter() {
		boolean result=true;
		usr1.setName("Jisoo Kim");
		assertEquals("Jisoo Kim",usr1.getName());
		if(usr1.getName().equals(usr3.getName())) {
			result=true;
		}
		else {
			result=false;
		}
		assertFalse(result);
	}
	@Test
	void testPhoneNumSetter() {
		boolean result=true;
		usr1.setPhoneNumber("01011118888");
		assertEquals("01011118888",usr1.getPhoneNumber());
		if(usr1.getPhoneNumber().equals(usr3.getPhoneNumber())) {
			result=true;
		}
		else {
			result=false;
		}
		assertFalse(result);
	}
	@Test
	void testEmailSetter() {
		boolean result=true;
		usr1.setEmailAddr("jisoo123@daum.com");
		assertEquals("jisoo123@daum.com",usr1.getEmailAddr());
		if(usr1.getEmailAddr().equals(usr3.getEmailAddr())) {
			result=true;
		}
		else {
			result=false;
		}
		assertFalse(result);
	}
	@Test
	void testActiveStateSetter() {
		boolean result=true;
		usr1.setActiveState(0);
		assertEquals(0,usr1.getActiveState());
		if(usr1.getActiveState()==(usr3.getActiveState())) {
			result=true;
		}
		else {
			result=false;
		}
		assertFalse(result);
	}
}
