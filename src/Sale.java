
public class Sale {
	private GeneralUser seller;
	private GeneralUser buyer;
	private Book book;
	
	public boolean equals(Sale other){
		boolean result;
	    if((other == null) || (getClass() != other.getClass())){
	        result = false;
	    } // end if
	    else{
	        Sale otherPeople = (Sale)other;
	        result = this.getSeller().equals(other.getSeller()) && this.getbuyer().equals(other.getbuyer()) && this.getBookBuying().equals(other.getBookBuying());
	    } // end else

	    return result;
	}
	
	Sale(GeneralUser seller, GeneralUser buyer, Book book){
		this.setSeller(seller);
		this.setBuyer(buyer);
		this.setBook(book);
	}
	
	public GeneralUser getSeller() {
		return seller;
	}
	
	public void setSeller(GeneralUser seller) {
		this.seller=new GeneralUser(seller);
	}
	
	public GeneralUser getbuyer() {
		return buyer;
	}
	
	public void setBuyer(GeneralUser buyer) {
		this.buyer=new GeneralUser(buyer);
	}
	
	public Book getBookBuying() {
		return book;
	}
	public void setBook(Book book) {
		this.book=new Book(book);
	}
	
	public void sendPurchaseMessage(String sellerEmail, String buyerEmail, int bookUniqueNum) {
		System.out.println("\n========================================================");
		System.out.println("Email Sent To Seller email:"+sellerEmail);
		System.out.println("Email Sent To Buyer email:"+buyerEmail);
		System.out.println("========================================================\n");
	}
	
	public void printSale(int i) {
		System.out.println("Sale #"+(i+1)+" | "+"SellerID:"+seller.getID()+" | "+ "BuyerID:"+buyer.getID()+" | "+ "bookName:"+book.getBookName());
	}
	/*private String sellerEmail;
	private String buyerEmail;
	private int bookUniqueNum;
	private String bookName;
	
	
	public Sale(String SelleremailAddr, String BuyeremailAddr, int bookUniqueNum) {
		this.setSellerID(SelleremailAddr);
		this.setBuyerEmail(BuyeremailAddr);
		this.setBookUniqueNum(bookUniqueNum);
	}
	public String getSellerEmail() {
		return this.sellerEmail;
	}
	public void setSellerID(String sellerEmail) {
		this.sellerEmail=sellerEmail;
	}
	public String getBuyerEmail() {
		return this.buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail=buyerEmail;
	}
	public int getBookUniqueNum() {
		return this.bookUniqueNum;
	}
	public void setBookUniqueNum(int bookUniqueNum) {
		this.bookUniqueNum=bookUniqueNum;
	}
	
	public void sendPurchaseMessage(String sellerEmail, String buyerEmail, int bookUniqueNum) {
		System.out.println("\n========================================================");
		System.out.println("Email Sent To Seller email:"+this.getSellerEmail());
		System.out.println("Email Sent To Buyer email:"+this.getBuyerEmail());
		System.out.println("========================================================\n");
	}
	
	public void printSale(int i) {
		System.out.println("Sale #"+(i+1)+" | "+"SellerEmail:"+sellerEmail+" | "+ "BuyerEmail:"+buyerEmail+" | "+ book)
	}*/
}
