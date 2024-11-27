package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private int qtyOrdered;
	private DigitalVideoDisc itemOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered]=disc;
			qtyOrdered+=1;
			System.out.println("Added item");
		}else {
			System.out.println("Max number reached");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		DigitalVideoDisc disc;
		for(int i=0;i<dvdList.length;i++) {
			disc=dvdList[i];
			if(qtyOrdered<MAX_NUMBERS_ORDERED) {
				itemOrdered[qtyOrdered]=disc;
				qtyOrdered+=1;
				System.out.println("Added item");
			}else {
				System.out.println("Max number reached");
				break;
			}
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered]=dvd1;
			qtyOrdered+=1;
			System.out.println("Added item");
		}else {
			System.out.println("Max number reached");
		}
		if(qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered]=dvd2;
			qtyOrdered+=1;
			System.out.println("Added item");
		}else {
			System.out.println("Max number reached");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i,j;
		for(i=0;i<qtyOrdered;i++) {
			if(itemOrdered[i]==disc) {
				for(j=i;j<qtyOrdered;j++) {
					itemOrdered[j]=itemOrdered[j+1];
				}
				break;
			}
		}
		if(i==qtyOrdered) {
			System.out.println("Item not found");
		}else {
			qtyOrdered-=1;
			System.out.println("Removed item");
		}
	}
	public float totalCost() {
		float total=0;
		int i;
		for(i=0;i<qtyOrdered;i++) {
			total+=itemOrdered[i].getCost();
		}
		return total;
	}
	public void listDVD() {
		int i;
		if(qtyOrdered==0) {
			System.out.println("Cart empty");
			return;
		}
		for(i=0;i<qtyOrdered;i++) {
			System.out.printf("DVD-%s-%s-%s-%d-%.2f\n",itemOrdered[i].getTitle(),itemOrdered[i].getCategory(),
					itemOrdered[i].getDirector(),itemOrdered[i].getLength(),itemOrdered[i].getCost());
		}
	}
	public void clearCart() {
		qtyOrdered=0;
		System.out.println("Cart cleared");
	}
	public void cartInfo() {
		System.out.println("***************************Cart***************************");
		System.out.println("List of product: ");
		listDVD();
		System.out.printf("Total cost is: %.2f\n",totalCost());
		System.out.println("**********************************************************");
	}
	public void searchDVD(int id) {
		int i;
		if(qtyOrdered==0) {
			System.out.println("Cart empty");
			return;
		}
		for(i=0;i<qtyOrdered;i++) {
			if(itemOrdered[i].getId()!=id)continue;
			System.out.printf("Found DVD\n");
			System.out.printf("DVD-%s-%s-%s-%d-%.2f\n",itemOrdered[i].getTitle(),itemOrdered[i].getCategory(),
					itemOrdered[i].getDirector(),itemOrdered[i].getLength(),itemOrdered[i].getCost());
			break;
		}
		if(i==qtyOrdered) {
			System.out.println("Not found");
			return;
		}
	}
	public void searchDVD(String title) {
		int i;
		if(qtyOrdered==0) {
			System.out.println("Cart empty");
			return;
		}
		for(i=0;i<qtyOrdered;i++) {
			if(!itemOrdered[i].getTitle().equals(title))continue;
			System.out.printf("Found DVD\n");
			System.out.printf("DVD-%s-%s-%s-%d-%.2f\n",itemOrdered[i].getTitle(),itemOrdered[i].getCategory(),
					itemOrdered[i].getDirector(),itemOrdered[i].getLength(),itemOrdered[i].getCost());
			break;
		}
		if(i==qtyOrdered) {
			System.out.println("Not found");
			return;
		}
	}
}