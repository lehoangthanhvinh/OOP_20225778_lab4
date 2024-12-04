package hust.soict.ict.aims;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.*;
import java.util.*;
public class Aims {
	public static void main(String[] args) {
		Cart anOrder=new Cart();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		anOrder.addMedia(dvd1);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		anOrder.addMedia(dvd2);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin","Animation",18.99f);
		anOrder.addMedia(dvd3);
		anOrder.cartInfo();
		anOrder.removeMedia("Star Wars");
		anOrder.addMedia(dvd1);
		anOrder.cartInfo();
		anOrder.searchDVD("The Lion King");
		anOrder.searchDVD(2);
		anOrder.searchDVD(1);
		ArrayList<Media> mediaList = new ArrayList<Media>();
		mediaList.add(dvd2);
		CompactDisc cd1=new CompactDisc("XOMU","XOMU playlist","Music Video",9.95f);
		mediaList.add(cd1);
		Book book1=new Book("Harry Potter","J.K.Rowling",29.95f);
		mediaList.add(book1);
		System.out.println("Before sort----------");
		for(Media media:mediaList) {
			System.out.println(media.getTitle().toString());
		}
		Collections.sort(mediaList,Media.COMPARE_BY_COST_TITLE);
		System.out.println("After sort-----------");
		for(Media media:mediaList) {
			System.out.println(media.getTitle().toString());
		}

	}
}