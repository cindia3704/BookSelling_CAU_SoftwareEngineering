
public class SaleList {
	private int maxNumOfSales=100;
	private int numOfSale=0;
	
	public Sale[] saleInformation= new Sale[maxNumOfSales];
	public int numSales() {
		return this.numOfSale;
	}
	
	public void incrementNumOfSales() {
		numOfSale++;
	}
	
	public Sale getSale(int i) {
		if(isInRange(i)) {
			return saleInformation[i];
		}
		else {
			return null;
		}
	}

	public boolean isInRange(int index) {
		if(index>=0 && index<100 && index<numOfSale) {
			return true;
		}
		else {
			return false;
		}
	}
	public void showSaleList() {
		System.out.println("\n===========================================================================================================");
		System.out.println("                                                 SALE LIST                                                       ");
		System.out.println("===========================================================================================================");
		for(int i=0;i<numOfSale;i++) {
			saleInformation[i].printSale(i);
			System.out.println("");
		}
	}
	/*public void addSale(Sale sale) {
		//System.out.println("SALE ADDED!");
		saleInformation[numOfSale++]=sale;
		//showSaleList();
	}*/
}
