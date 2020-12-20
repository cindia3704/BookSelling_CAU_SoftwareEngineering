
public interface VerificationInterface {
	public boolean isPhoneNumber(String phoneNumber);
	public boolean isEmailAddress(String emailAddress);
	public boolean isBookPublishedDate(String bookPublishedDate);
	public boolean isPrice(String bookPrice);
	public boolean isbnExists(BookList bookList,String isbn);
	public boolean verifyUser(UserList userList,String id, String password);
	public boolean checkDuplicateID(UserList userList,String id);
}
