import java.io.IOException;

public interface GeneralUserInterface {
	public void userSearchBook(BookList bookList);
	public void userPurchaseBook(BookList bookList, UserList userList,SaleList saleList);
	public void registerBook(BookList bookList);
	public void displayMyBooks(BookList bookList);
	public void startMainMenuForUser(UserList userList,UserListFile userListFile,BookListFile bookListFile, BookList bookList,SaleListFile saleListFile, SaleList saleList) throws IOException;
}
