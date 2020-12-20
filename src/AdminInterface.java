import java.io.IOException;

public interface AdminInterface {
	public void adminSearchBook(BookList bookList);
	public void adminShowUserList(UserList userList);
	public void adminChangeUserState(UserList userList);
	public void adminDeleteUser(BookList bookList, UserList userList);
	public void adminDeleteBook(BookList bookList);
	public void startMainMenuForAdmin(UserList userList, UserListFile userListFile, BookListFile bookListFile,
			BookList bookList, SaleListFile saleListFile) throws IOException;
}
