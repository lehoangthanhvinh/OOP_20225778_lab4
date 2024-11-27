package hust.soict.ict.aims.store;

import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_DISPLAYED=100;
	private int qtyDisplayed;
	private DigitalVideoDisc itemDisplayed[]=new DigitalVideoDisc[MAX_NUMBERS_DISPLAYED];
	public void addDVD(DigitalVideoDisc disc) {
		if(qtyDisplayed<MAX_NUMBERS_DISPLAYED) {
			itemDisplayed[qtyDisplayed]=disc;
			qtyDisplayed+=1;
			System.out.println("Added item");
		}else {
			System.out.println("Max number reached");
		}
	}
	public void removeDVD(DigitalVideoDisc disc) {
		int i,j;
		for(i=0;i<qtyDisplayed;i++) {
			if(itemDisplayed[i]==disc) {
				for(j=i;j<qtyDisplayed;j++) {
					itemDisplayed[j]=itemDisplayed[j+1];
				}
				break;
			}
		}
		if(i==qtyDisplayed) {
			System.out.println("Item not found");
		}else {
			qtyDisplayed-=1;
			System.out.println("Removed item");
		}
	}
}
