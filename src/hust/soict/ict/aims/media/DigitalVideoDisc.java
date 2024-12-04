
package hust.soict.ict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.id=nbMedia;
		nbMedia++;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.id=nbMedia;
		nbMedia++;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public void play() {
		System.out.println("Playing DVD: "+this.getTitle());
		System.out.println("DVD length: "+this.getLength());
	}
}
