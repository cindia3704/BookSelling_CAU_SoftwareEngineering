
public class Display implements DisplayInterface{
	
	public void displayStartMenu(){
		System.out.println("====================START MENU=====================");
		System.out.println("1. Log In");
		System.out.println("2. Sign Up");
	}
	public void displayMainMenuForUser(String name) {
		System.out.println("\n===========MAIN MENU (Logged in as "+name+")===========");
		System.out.println("1. Search Books");
		System.out.println("2. Purchase Book");
		System.out.println("3. Register Book");
		System.out.println("4. Modify/Delete My Book");
		System.out.println("5. Log Out");
	}
	public void displayMainMenuForAdmin() {
		System.out.println("\n===========MAIN MENU (Logged in as Admin)===========");
		System.out.println("1. Search Books");
		System.out.println("2. See User List");
		System.out.println("3. Change User State");
		System.out.println("4. Delete User");
		System.out.println("5. Delete Book");
		System.out.println("6. Log Out");
	}
	public void displayForBookSearch() {
		System.out.println("=====================Book Search====================");
		System.out.println("1. Search by Book Name");
		System.out.println("2. Search by ISBN");
		System.out.println("3. Search by Author");
		System.out.println("4. Search by Seller ID");
		System.out.println("5. Search by Publisher");
		System.out.println("6. Search by PublishedDate");
		System.out.println("7.Quit");

	}
	public void displayForBookPurchase() {
		System.out.println("=====================Book Purchase====================");
		System.out.println("1. Search by Book Name");
		System.out.println("2. Search by ISBN");
		System.out.println("3. Search by Author");
		System.out.println("4. Search by Seller ID");
		System.out.println("5. Search by Publisher");
		System.out.println("6. Search by PublishedDate");
		System.out.println("7. Quit");
	}
	public void displayMyBookOptions() {
		System.out.println("Choose Option");
		System.out.println("1.Modify My Book");
		System.out.println("2.Delete My Book");
		System.out.println("3.Go to Main Menu");
	}
	public void displayLogOut() {
		System.out.println("\nLogged Out Successfully!");
	}

} 
