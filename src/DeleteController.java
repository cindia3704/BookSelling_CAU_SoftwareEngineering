
public class DeleteController implements DeleteElement{
	public void deleteUser(UserList userList,String id) {
		boolean found=false;
		for(int i=0;i<userList.numUsers();i++) {
			if(userList.userInformation[i].getID().equals(id)){
				found=true;
				for(int j=i+1;j<userList.numUsers();j++) {
					userList.userInformation[i]=userList.userInformation[j];
					i++;
				}
		 		userList.decrementNumOfUsers();
			} 
		}
		if(found==false) {
			System.out.println("ID: "+id+" is NOT FOUND!");
		}
	}
	public void deleteBook(BookList bookList,int bookUniqueNum) {
		boolean found=false;
		for(int i=0;i<bookList.numBooks();i++) {
			if(bookList.bookInformation[i].getBookUniqueNum()==bookUniqueNum) {
				found=true;
				for(int j=i+1;j<bookList.numBooks();j++) {
					bookList.bookInformation[i].setBookAuthor(bookList.bookInformation[j].getBookAuthor());
					bookList.bookInformation[i].setBookName(bookList.bookInformation[j].getBookName());
					bookList.bookInformation[i].setBookISBN(bookList.bookInformation[j].getBookISBN());
					bookList.bookInformation[i].setBookPublisher(bookList.bookInformation[j].getBookPublisher());
					bookList.bookInformation[i].setBookPublishedDate(bookList.bookInformation[j].getBookPublishedDate());
					bookList.bookInformation[i].setBookPrice(bookList.bookInformation[j].getBookPrice());
					bookList.bookInformation[i].setBookState(bookList.bookInformation[j].getBookState());
					bookList.bookInformation[i].setBookSellerID(bookList.bookInformation[j].getBookSellerID());
					bookList.bookInformation[i].setBookUniqueNum(bookList.bookInformation[j].getBookUniqueNum()-1);
					i++;
				}
				//numOfBooks--;
				bookList.decrementNumOfBooks();
			}
		}
		if(found==false) {
			System.out.println("Book is not Found! No book to delete");
		}
	}
	public void deleteBook(BookList bookList,String id) {
		boolean found=false;
		int loopTimes=bookList.numBooks();
		for(int i=0;i<loopTimes;i++) {
			//int index=0;
			for(int k=0;k<bookList.numBooks();k++) {
				int index=k;
				if(bookList.bookInformation[index].getBookSellerID().equals(id)) {
					found=true;
					for(int j=index+1;j<bookList.numBooks();j++) {
						bookList.bookInformation[index]=bookList.bookInformation[j];
						bookList.bookInformation[index].setBookUniqueNum(bookList.bookInformation[j].getBookUniqueNum()-1);
						index++;
					}
					bookList.decrementNumOfBooks();
				}
			}
			
		}
		if(found==false) {
			System.out.println("Book is not Found! No book to delete");
		}
	}
}
