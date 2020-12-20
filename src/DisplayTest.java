import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayTest {
	Display display= new Display();
	@Test
	public void testDisplayLogOut() throws Exception {
	    PrintStream oldOut = System.out;
	    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteOutput));

	    display.displayLogOut();
	    System.setOut(oldOut);

	    String output = new String(byteOutput.toByteArray());

	    assertTrue(output.contains("\nLogged Out Successfully!"));

	}
	@Test
	public void testDisplayStartMenu() throws Exception {
	    PrintStream oldOut = System.out;
	    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteOutput));

	    display.displayStartMenu();
	    System.setOut(oldOut);

	    String output = new String(byteOutput.toByteArray());

	    assertTrue(output.contains("====================START MENU====================="));
	    assertTrue(output.contains("1. Log In"));
	    assertTrue(output.contains("2. Sign Up"));
	}
	@Test
	public void testDisplayMainMenuForUser() throws Exception {
	    PrintStream oldOut = System.out;
	    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteOutput));

	    display.displayMainMenuForUser("Jisoo");
	    System.setOut(oldOut);

	    String output = new String(byteOutput.toByteArray());

	    //assertTrue(output.contains("\nLogged Out Successfully!"));
	    assertTrue(output.contains("\n===========MAIN MENU (Logged in as "+"Jisoo"+")==========="));
	    assertTrue(output.contains("1. Search Books"));
	    assertTrue(output.contains("2. Purchase Book"));
	    assertTrue(output.contains("3. Register Book"));
	    assertTrue(output.contains("4. Modify/Delete My Book"));
	    assertTrue(output.contains("5. Log Out"));
	}
	@Test
	public void testDisplayMainMenuForAdmin() throws Exception {
	    PrintStream oldOut = System.out;
	    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteOutput));

	    display.displayMainMenuForAdmin();
	    System.setOut(oldOut);

	    String output = new String(byteOutput.toByteArray());
	    assertTrue(output.contains("\n===========MAIN MENU (Logged in as Admin)==========="));
	    assertTrue(output.contains("1. Search Books"));
	    assertTrue(output.contains("2. See User List"));
	    assertTrue(output.contains("3. Change User State"));
	    assertTrue(output.contains("4. Delete User"));
	    assertTrue(output.contains("5. Delete Book"));
	    assertTrue(output.contains("6. Log Out"));

	}
	@Test
	public void testDisplayForBookSearch() throws Exception {
	    PrintStream oldOut = System.out;
	    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteOutput));

	    display.displayForBookSearch();
	    System.setOut(oldOut);

	    String output = new String(byteOutput.toByteArray());
	    assertTrue(output.contains("=====================Book Search===================="));
	    assertTrue(output.contains("1. Search by Book Name"));
	    assertTrue(output.contains("2. Search by ISBN"));
	    assertTrue(output.contains("3. Search by Author"));
	    assertTrue(output.contains("4. Search by Seller ID"));
	    assertTrue(output.contains("5. Search by Publisher"));
	    assertTrue(output.contains("6. Search by PublishedDate"));
	    assertTrue(output.contains("7.Quit"));

	}
	@Test
	public void testDisplayForBookPurchase() throws Exception {
	    PrintStream oldOut = System.out;
	    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteOutput));

	    display.displayForBookPurchase();
	    System.setOut(oldOut);

	    String output = new String(byteOutput.toByteArray());
	    assertTrue(output.contains("=====================Book Purchase===================="));
	    assertTrue(output.contains("1. Search by Book Name"));
	    assertTrue(output.contains("2. Search by ISBN"));
	    assertTrue(output.contains("3. Search by Author"));
	    assertTrue(output.contains("4. Search by Seller ID"));
	    assertTrue(output.contains("5. Search by Publisher"));
	    assertTrue(output.contains("6. Search by PublishedDate"));
	    assertTrue(output.contains("7. Quit"));

	}
	@Test
	public void testDisplayMyBookOptions() throws Exception {
	    PrintStream oldOut = System.out;
	    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(byteOutput));

	    display.displayMyBookOptions();
	    System.setOut(oldOut);

	    String output = new String(byteOutput.toByteArray());
	    assertTrue(output.contains("Choose Option"));
	    assertTrue(output.contains("1.Modify My Book"));
	    assertTrue(output.contains("2.Delete My Book"));
	    assertTrue(output.contains("3.Go to Main Menu"));
	}
}
