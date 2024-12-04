package hust.soict.ict.aims.media;
import java.util.*;
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public List<String> getAuthors() {
		return authors;
	}

	public void addAuthor(String authorName) {
		int i;
		for(i=0;i<authors.size();i++) {
			if(authorName.equals(authors.get(i)))break;
		}
		if(i==authors.size()) {
			authors.add(authorName);
			System.out.println("Added author");
		}else {
			System.out.println("Author is already added");
		}
	}
	public void removeAuthor(String authorName) {
		int i;
		for(i=0;i<authors.size();i++) {
			if(authorName.equals(authors.get(i))) {
				authors.remove(i);
				System.out.println("Removed author");
			}
		}
		if(i==authors.size()) {
			System.out.println("Author not found");
		}
	}
	public Book(String title,String category,float cost) {
		super();
		this.id = nbMedia;
		nbMedia++;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
}
