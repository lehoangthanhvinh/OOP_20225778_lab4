package hust.soict.ict.aims;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.*;
import java.util.*;
public class Application {
	Store testStore = new Store();
	Cart testCart = new Cart();
	static Scanner key=new Scanner(System.in);
	public void showMenu() {
		while(true) {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			int cmd=key.nextInt();
			switch(cmd){
				case 1:storeMenu();break;
				case 2:updateStore();break;
				case 3:cartMenu();break;
				case 0:return;
				default:showMenu();break;
			}
		}
	}
	public void updateStore() {
		while(true) {
			System.out.println("Update store: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add item");
			System.out.println("2. Remove item");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int cmd=key.nextInt();
			if(cmd==0)return;
			System.out.println("Item type: ");
			System.out.println("--------------------------------");
			System.out.println("1. Digital video disc");
			System.out.println("2. Compact disc");
			System.out.println("3. Book");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			int item=key.nextInt();
			if(item==0)return;
			switch(cmd) {
			case 1:
				System.out.print("Enter name: ");
				String name=key.next();
				System.out.print("Enter category: ");
				String category=key.next();
				System.out.print("Enter cost: ");
				float cost=key.nextFloat();
				switch(item) {
				case 1:
					System.out.print("Enter length: ");
					int length=key.nextInt();
					System.out.print("Enter director: ");
					String director=key.next();
					DigitalVideoDisc dvd = new DigitalVideoDisc(name,category,director,length,cost);
					testStore.addMedia(dvd);
					testStore.addDigitalVideoDisc(dvd);
					break;
				case 2:
					System.out.print("Enter artist: ");
					String artist=key.next();
					CompactDisc cd = new CompactDisc(artist,name,category,cost);
					testStore.addMedia(cd);
					testStore.addCompactDisc(cd);
					break;
				case 3:
					Book book = new Book(name,category,cost);
					testStore.addMedia(book);
					testStore.addBook(book);
					break;
				}
				break;
			case 2:
				System.out.print("Enter name: ");
				String delName=key.next();
				testStore.removeMedia(delName);
				switch(item) {
				case 1:testStore.removeDigitalVideoDisc(delName);break;
				case 2:testStore.removeCompactDisc(delName);break;
				case 3:testStore.removeBook(delName);break;
				}
				break;
			}
		}
	}
	public void storeMenu() {
		while(true) {
			testStore.storeInfo();
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			int cmd=key.nextInt();
			switch(cmd){
				case 1:
					System.out.print("Enter name: ");
					String name=key.next();
					testStore.searchDVD(name);
					mediaDetailsMenu(name);
					break;
				case 2:
					System.out.print("Enter name: ");
					String find=key.next();
					addMedia(find);
					break;
				case 3:
					System.out.print("Enter name: ");
					String play=key.next();
					addMedia(play);
					break;
				case 4:cartMenu();break;
				case 0:return;
				default:storeMenu();break;
			}
		}
	}
	public void addMedia(String name) {
		int i;
		ArrayList<Media> displayList=testStore.getItemDisplayed();
		for(i=0;i<displayList.size();i++) {
			if(name.equals(displayList.get(i).getTitle())) {
				testCart.addMedia(displayList.get(i));
			}
		}
	}
	public void playMedia(String name) {
		int i;
		ArrayList<DigitalVideoDisc> dvd=testStore.getDvd();
		ArrayList<CompactDisc> cd=testStore.getCd();
		for(i=0;i<dvd.size();i++) {
			if(name.equals(dvd.get(i).getTitle())) {
				dvd.get(i).play();
				return;
			}
		}
		for(i=0;i<cd.size();i++) {
			if(name.equals(cd.get(i).getTitle())) {
				cd.get(i).play();
				return;
			}
		}
		System.out.println("Item not found in store");
	}
	public void mediaDetailsMenu(String name) {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int cmd=key.nextInt();
			switch(cmd){
				case 1:addMedia(name);break;
				case 2:playMedia(name);break;
				case 0:return;
			}
		}
	}
	public void sortCart() {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Sort medias by title");
			System.out.println("2. Sort medias by cost");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int cmd=key.nextInt();
			switch(cmd) {
			case 1:
				Collections.sort(testCart.getItemOrdered(),Media.COMPARE_BY_COST_TITLE);
				break;
			case 2:
				Collections.sort(testCart.getItemOrdered(),Media.COMPARE_BY_TITLE_COST);
				break;
			case 0:return;
			}
		}
	}
	public void cartMenu() {
		while(true) {
			testCart.cartInfo();
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			int cmd=key.nextInt();
			switch(cmd){
				case 1:/*Filter*/;break;
				case 2:
					sortCart();
					break;
				case 3:
					System.out.print("Enter name: ");
					String remove=key.next();
					testCart.removeMedia(remove);
					break;
				case 4:
					System.out.print("Enter name: ");
					String play=key.next();
					addMedia(play);
					break;
				case 5:
					testCart.clearCart();
					break;
				case 0:return;
				default:cartMenu();break;
			}
		}
	}
	public static void main(String[] args) {
		Application call=new Application();
		call.showMenu();
	}
}
