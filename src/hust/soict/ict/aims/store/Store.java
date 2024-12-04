package hust.soict.ict.aims.store;

import hust.soict.ict.aims.media.*;
import java.util.*;
public class Store {
	private ArrayList<Media> itemDisplayed = new ArrayList<Media>();
	private ArrayList<DigitalVideoDisc> dvd=new ArrayList<DigitalVideoDisc>();
	private ArrayList<CompactDisc> cd=new ArrayList<CompactDisc>();
	private ArrayList<Book> book=new ArrayList<Book>();
	public void addMedia(Media mediaObject) {
		itemDisplayed.add(mediaObject);
		System.out.println("Added item");
	}
	public void addDigitalVideoDisc(DigitalVideoDisc mediaObject) {
		dvd.add(mediaObject);
	}
	public void addCompactDisc(CompactDisc mediaObject) {
		cd.add(mediaObject);
	}
	public void addBook(Book mediaObject) {
		book.add(mediaObject);
	}
	public void removeMedia(String mediaObject) {
		int i;
		for(i=0;i<itemDisplayed.size();i++) {
			if(itemDisplayed.get(i).getTitle()==mediaObject) {
				itemDisplayed.remove(i);
				System.out.println("Removed item");
				break;
			}
		}
		if(i==itemDisplayed.size())System.out.println("Item not found");
	}
	public void removeDigitalVideoDisc(String mediaObject) {
		int i;
		for(i=0;i<dvd.size();i++) {
			if(dvd.get(i).getTitle()==mediaObject) {
				dvd.remove(i);
				break;
			}
		}
	}
	public void removeCompactDisc(String mediaObject) {
		int i;
		for(i=0;i<cd.size();i++) {
			if(cd.get(i).getTitle()==mediaObject) {
				cd.remove(i);
				break;
			}
		}
	}
	public void removeBook(String mediaObject) {
		int i;
		for(i=0;i<book.size();i++) {
			if(book.get(i).getTitle()==mediaObject) {
				book.remove(i);
				break;
			}
		}
	}
	public ArrayList<Media> getItemDisplayed() {
		return itemDisplayed;
	}
	public ArrayList<DigitalVideoDisc> getDvd() {
		return dvd;
	}
	public ArrayList<CompactDisc> getCd() {
		return cd;
	}
	public ArrayList<Book> getBook() {
		return book;
	}
	public void listDVD() {
		int i;
		if(itemDisplayed.size()==0) {
			System.out.println("Store empty");
			return;
		}
		for(i=0;i<itemDisplayed.size();i++) {
			System.out.printf("Product-%d-%s-%s-%.2f\n",itemDisplayed.get(i).getId(),
					itemDisplayed.get(i).getTitle(),itemDisplayed.get(i).getCategory(),itemDisplayed.get(i).getCost());
		}
	}
	public void storeInfo() {
		System.out.println("***************************Store***************************");
		System.out.println("List of product: ");
		listDVD();
		System.out.println("***********************************************************");
	}
	public void searchDVD(String title) {
		int i;
		if(itemDisplayed.size()==0) {
			System.out.println("Store empty");
			return;
		}
		for(i=0;i<itemDisplayed.size();i++) {
			if(!itemDisplayed.get(i).getTitle().equals(title))continue;
			System.out.printf("Found product\n");
			System.out.printf("Product-%d-%s-%s-%.2f\n",itemDisplayed.get(i).getId(),
					itemDisplayed.get(i).getTitle(),itemDisplayed.get(i).getCategory(),itemDisplayed.get(i).getCost());
			break;
		}
		if(i==itemDisplayed.size()) {
			System.out.println("Not found");
			return;
		}
	}
}
