
public class Admin extends User {
	public Admin() {
		this.setID(this.getID());
		this.setPassword(this.getPassword());
	}
	public String getID() {
		return "admin";
	}
	
	public String getPassword() {
		return "nayana";
	}
	
}
