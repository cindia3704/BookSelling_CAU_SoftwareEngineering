
public interface AddElement {
	public void addBook(BookList bookList, Book book);
	public void addUser(UserList userList, GeneralUser user);
	public String makeISBN(BookList bookList);
	public void addSale(SaleList saleList, Sale sale);
}
