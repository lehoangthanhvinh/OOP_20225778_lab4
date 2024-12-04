package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.*;
import java.util.*;
public class Cart {
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	public void addMedia(Media mediaObject) {
		itemOrdered.add(mediaObject);
		System.out.println("Added item");
	}
	public void removeMedia(String mediaObject) {
		int i;
		for(i=0;i<itemOrdered.size();i++) {
			if(itemOrdered.get(i).getTitle().equals(mediaObject)) {
				itemOrdered.remove(i);
				System.out.println("Removed item");
				break;
			}
		}
		if(i==itemOrdered.size())System.out.println("Item not found");
	}
	public float totalCost() {
		float total=0;
		int i;
		for(i=0;i<itemOrdered.size();i++) {
			total+=itemOrdered.get(i).getCost();
		}
		return total;
	}
	public void listDVD() {
		int i;
		if(itemOrdered.size()==0) {
			System.out.println("Cart empty");
			return;
		}
		for(i=0;i<itemOrdered.size();i++) {
			System.out.printf("Product-%d-%s-%s-%.2f\n",itemOrdered.get(i).getId(),
					itemOrdered.get(i).getTitle(),itemOrdered.get(i).getCategory(),itemOrdered.get(i).getCost());
		}
	}
	public void clearCart() {
		itemOrdered.clear();
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
		if(itemOrdered.size()==0) {
			System.out.println("Cart empty");
			return;
		}
		for(i=0;i<itemOrdered.size();i++) {
			if(itemOrdered.get(i).getId()!=id)continue;
			System.out.printf("Found product\n");
			System.out.printf("Product-%d-%s-%s-%.2f\n",itemOrdered.get(i).getId(),
					itemOrdered.get(i).getTitle(),itemOrdered.get(i).getCategory(),itemOrdered.get(i).getCost());
			break;
		}
		if(i==itemOrdered.size()) {
			System.out.println("Not found");
			return;
		}
	}
	public void searchDVD(String title) {
		int i;
		if(itemOrdered.size()==0) {
			System.out.println("Cart empty");
			return;
		}
		for(i=0;i<itemOrdered.size();i++) {
			if(!itemOrdered.get(i).getTitle().equals(title))continue;
			System.out.printf("Found product\n");
			System.out.printf("Product-%d-%s-%s-%.2f\n",itemOrdered.get(i).getId(),
					itemOrdered.get(i).getTitle(),itemOrdered.get(i).getCategory(),itemOrdered.get(i).getCost());
			break;
		}
		if(i==itemOrdered.size()) {
			System.out.println("Not found");
			return;
		}
	}
	public ArrayList<Media> getItemOrdered() {
		return itemOrdered;
	}
}