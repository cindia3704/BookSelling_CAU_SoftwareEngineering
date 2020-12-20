import java.util.regex.Pattern;

public class VerificationController implements VerificationInterface{
	public boolean isBookPublishedDate(String bookPublishedDate) {
		if((Pattern.matches("[0-9]*$",bookPublishedDate)&&bookPublishedDate.length()==8)) {
			int year =Integer.parseInt(bookPublishedDate.substring(0,4));
			int month=Integer.parseInt(bookPublishedDate.substring(4,6));
			int day=Integer.parseInt(bookPublishedDate.substring(6,8));
			 
			if(year<1000) {
				System.out.println("Year is not in range. REENTER!!");
				return false;
			}
			else if(month<1||month>12) {
				System.out.println("Month is not in range. REENTER!!");
				return false;
			}
			else if(day<1||day>31) {
				System.out.println("Day is not in range. REENTER!!");
				return false;
			}else {
				return true;
			}
		}
		else {
			System.out.println("Book published date is not in format. REENTER!!");
			return false;
		}
	}
	public boolean isPrice(String bookPrice) {
		if(Pattern.matches("[0-9]*$",bookPrice)||bookPrice.equals("null")) {
			return true;
		}
		else {
			System.out.println("Price is not in format. REENTER!!");
			return false;
		}
	}
	public boolean isbnExists(BookList bookList, String isbn) {
		boolean result=false;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookISBN().equals(isbn)) {
				result=true;
			}
		}
		return result;
	}
	public boolean isPhoneNumber(String phoneNumber) {
		if(Pattern.matches("^[0-9]*$", phoneNumber)&&phoneNumber.length()==11) {
			return true;
		}
		else {
			System.out.println("Phone number is not in format. REENTER!!");
			return false;
		}
	}
	
	public boolean isEmailAddress(String emailAddress) {
		if(emailAddress.equals("null")) {
			return true;
		}
		else if(Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", emailAddress)) {
			return true;
		}
		else {
			System.out.println("Email is not in format. REENTER!!");
			return false;
		}
	}
	public boolean verifyUser(UserList userList,String id, String password) {
		//GeneralUser loggedUser=null;
		boolean result=false;
		for(int i=0;i<userList.numUsers();i++) {
			if(userList.userInformation[i].getID().equals(id)) {
				if(userList.userInformation[i].getPassword().contentEquals(password)) {
					result=true;
				}
			}
		}
		return result;
	}
	public boolean checkDuplicateID(UserList userList,String id) {
		boolean result=true;
		for(int i=0;i<userList.numUsers();i++) {
			if(userList.userInformation[i].getID().equals(id)) {
				result=false;
			}
		}
		return result;
	}
}
