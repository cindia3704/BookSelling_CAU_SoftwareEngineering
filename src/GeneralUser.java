
public class GeneralUser extends User{
	private String name;
	private String phoneNumber;
	private String emailAddr;
	private int activeState;   //0=deactivated, 1=activated
	
	public boolean equals(GeneralUser other){
		boolean result;
	    if((other == null) || (getClass() != other.getClass())){
	        result = false;
	    } // end if
	    else{
	        GeneralUser otherPeople = (GeneralUser)other;
	        result = this.getID().equals(other.getID()) && this.getPassword().equals(other.getPassword()) && name.equals(other.getName()) &&  phoneNumber.equals(other.getPhoneNumber())&& emailAddr.contentEquals(other.getEmailAddr()) && (activeState==other.getActiveState());
	    } // end else

	    return result;
	}
	public GeneralUser(String id, String password, String name, String phoneNumber, String emailAddr, int activeState){
		this.setID(id);
		this.setPassword(password);
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddr(emailAddr);
		this.setActiveState(activeState);
	}
	
	public GeneralUser(GeneralUser user) {
		this.setID(user.getID());
		this.setPassword(user.getPassword());
		this.setName(user.getName());
		this.setPhoneNumber(user.getPhoneNumber());
		this.setEmailAddr(user.getEmailAddr());
		this.setActiveState(user.getActiveState());
	}

	
	public void setIDNum(int idNum) {
		//this.idNum=idNum;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getEmailAddr() {
		return this.emailAddr;
	}
	
	public void setEmailAddr(String emailAddr) {
		this.emailAddr=emailAddr;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	public int getActiveState() {
		return this.activeState;
	}
	
	public void setActiveState(int activeState) {
		this.activeState=activeState;
	}
	public String printActiveState(int activeState) {
		if(activeState==0) {
			return "DEACTIVATED";
		}
		else {
			return "ACTIVATED";
		}
	}
	
	public void printUser(int i) {
		System.out.println("Index:"+(i+1)+" | "+ "ID:"+ getID()+ " | " + "Password: "+getPassword()+ " | "+"Name:"+getName()+" | "+"Phone Number:"+getPhoneNumber()+" | "+"Email: "+getEmailAddr()+ " | "+ "State:"+printActiveState(getActiveState())+"\n");
	}
	
}
