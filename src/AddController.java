import java.math.BigInteger;
import java.util.Random;

public class AddController implements AddElement{
	public void addBook(BookList bookList, Book book) {
		bookList.bookInformation[bookList.numBooks()]=book;
		bookList.incrementNumOfBooks();
	}
	public void addUser(UserList userList, GeneralUser user) {
		userList.userInformation[userList.numUsers()]=user;
		userList.incrementNumOfUsers();
	}
	public String makeISBN(BookList bookList) {
		//HAVE TO COMPLETE
		VerificationInterface verification=new VerificationController();
		boolean exists=true;
		Random rand=new Random();
		int optionDigit=1;
		BigInteger maxLimit1=new BigInteger("9999999999");
		BigInteger minLimit1=new BigInteger("1000000000");
		BigInteger maxLimit2=new BigInteger("9999999999999");
		BigInteger minLimit2=new BigInteger("1000000000000");
		int opDigit=rand.nextInt(optionDigit);
		int isbnNum=0;
		int radix=10;
		String isbn="";
		if(opDigit==0) {
			//10자리 ISBN
			while(exists) {
				BigInteger option1=maxLimit1.subtract(minLimit1);
				int len=maxLimit1.bitLength();
				BigInteger res=new BigInteger(len,rand);
				if(res.compareTo(minLimit1)<0) {
					res=res.add(minLimit1);
				}
				if(res.compareTo(option1)>=0) {
					res=res.mod(option1).add(minLimit1);
				}
				isbn=res.toString(radix);
				if(!verification.isbnExists(bookList,isbn)) {
					exists=false;
				}
			}
		}
		else {
			//13자기 ISBN
			while(!exists) {
				BigInteger option2=maxLimit2.subtract(minLimit2);
				int len=maxLimit2.bitLength();
				BigInteger res=new BigInteger(len,rand);
				if(res.compareTo(minLimit2)<0) {
					res=res.add(minLimit2);
				}
				if(res.compareTo(option2)>=0) {
					res=res.mod(option2).add(minLimit2);
				}
				isbn=res.toString(radix);
				if(verification.isbnExists(bookList,isbn)) {
					exists=true;
				}
			}
		}
		return isbn;
	}
	public void addSale(SaleList saleList,Sale sale) {
		//System.out.println("SALE ADDED!");
		saleList.saleInformation[saleList.numSales()]=sale;
		saleList.incrementNumOfSales();
		//showSaleList();
	}
}
